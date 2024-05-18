package mvc.member.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.member.model.MemberDAO;

public class LoginProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		boolean result = dao.memerIdCheck(id, pw);
		
		HttpSession session = request.getSession();
		
		if (result == true) {
			session.setAttribute("sid", id);
		}
		request.setAttribute("result", result);
		
		return "/WEB-INF/views/member/loginPro.jsp";
	}
}