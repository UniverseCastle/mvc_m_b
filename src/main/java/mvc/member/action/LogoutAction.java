package mvc.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sid = request.getSession();
		if (sid != null) {
			sid.invalidate();
		}
		
		return "/WEB-INF/views/member/logout.jsp";
	}
}