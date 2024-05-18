package mvc.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.board.model.BoardDAO;
import mvc.board.model.BoardDTO;
import mvc.member.action.SuperAction;

public class ListAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sid = request.getSession();
		request.setAttribute("sid", sid);
		
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int num = 0;
		
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardDTO> list = null;
		count = dao.boardCount();
		
		if (count > 0) {
			list = dao.boardList(startRow, endRow);
		}
		
		num = count - (currentPage - 1) * pageSize;
		BoardDTO dto = dao.boardReadContent(num);
		if (dto.getImg() != null) {
			request.setAttribute("img", dto.getImg());
		}
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("list", list);
		
		return "/WEB-INF/views/board/list.jsp";
	}
}