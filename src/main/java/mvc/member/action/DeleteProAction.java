package mvc.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.member.model.MemberDAO;

public class DeleteProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String sid = (String)session.getAttribute("sid");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.memberDelete(sid, pw);
		
		if (result == 1) {
			session.invalidate();
		}
		
		request.setAttribute("result", result);
		
		return "/WEB-INF/views/member/deletePro.jsp";
	}
}