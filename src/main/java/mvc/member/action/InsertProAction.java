package mvc.member.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.member.model.MemberDAO;
import mvc.member.model.MemberDTO;

public class InsertProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = new MemberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setBirth(request.getParameter("birth"));
		dto.setPhone1(request.getParameter("phone1"));
		dto.setPhone2(request.getParameter("phone2"));
		dto.setGender(request.getParameter("gender"));
		
		int result = dao.memberInsert(dto);
		
		request.setAttribute("result", result);
		
		return "/WEB-INF/views/member/insertPro.jsp";
	}
}