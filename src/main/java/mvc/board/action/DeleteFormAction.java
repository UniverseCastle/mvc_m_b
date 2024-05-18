package mvc.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.member.action.SuperAction;

public class DeleteFormAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		request.setAttribute("num", num);
		
		return "/WEB-INF/views/board/deleteForm.jsp";
	}
}