package mvc.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sid = request.getSession();
		request.setAttribute("sid", sid);
		
		return "/WEB-INF/views/member/main.jsp";
	}
}