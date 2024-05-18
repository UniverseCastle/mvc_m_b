package mvc.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDAO;
import mvc.board.model.BoardDTO;
import mvc.member.action.SuperAction;

public class UpdateFormAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.boardInfo(num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("num", num);
		
		return "/WEB-INF/views/board/updateForm.jsp";
	}
}