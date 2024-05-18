package mvc.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDAO;
import mvc.board.model.BoardDTO;
import mvc.member.action.SuperAction;

public class ContentAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = new BoardDTO();
		dto = dao.boardReadContent(num);
		
		BoardDTO dto_pre = dao.boardReadContent(num-1);
		String title_pre = dto_pre.getTitle();
		
		BoardDTO dto_next = dao.boardReadContent(num+1);
		String title_next = dto_next.getTitle();
		
		request.setAttribute("dto", dto);
		request.setAttribute("title_pre", title_pre);
		request.setAttribute("title_next", title_next);
		
		return "/WEB-INF/views/board/content.jsp";
	}
}