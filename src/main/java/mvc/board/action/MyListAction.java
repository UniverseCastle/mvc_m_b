package mvc.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.board.model.BoardDAO;
import mvc.board.model.BoardDTO;
import mvc.member.action.SuperAction;

public class MyListAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String sid = (String)session.getAttribute("sid");
		
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int myCount = 0;
		int num = 0;
		
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardDTO> myList = null;
		myCount = dao.boardMyCount(sid);
		
		if (myCount > 0) {
			myList = dao.boardMyList(startRow, endRow, sid);
		}
		
		num = myCount - (currentPage - 1) * pageSize;
		BoardDTO dto = dao.boardReadContent(num);
		if (dto.getImg() != null) {
			request.setAttribute("img", dto.getImg());
		}
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("myCount", new Integer(myCount));
		request.setAttribute("myList", myList);
		
		return "/WEB-INF/views/board/myList.jsp";
	}
}