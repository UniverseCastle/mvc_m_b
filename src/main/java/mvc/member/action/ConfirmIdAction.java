package mvc.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.member.model.MemberDAO;

public class ConfirmIdAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		boolean result = dao.memberConfirmId(id);
		
		request.setAttribute("result", result);
		
		return "/WEB-INF/views/member/confirmId.jsp";
	}
}