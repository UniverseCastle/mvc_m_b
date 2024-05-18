package mvc.board.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDAO;
import mvc.member.action.SuperAction;

import java.io.File;

public class DeleteProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int result = 0;
		int num = Integer.parseInt(request.getParameter("num"));
		String passwd = request.getParameter("passwd");
		String filePath = request.getRealPath("resources/upload");
		
		BoardDAO dao = BoardDAO.getInstance();
		String img = dao.imgName(num);
		result = dao.boardDelete(num, passwd);
		
		if (result == 1 && !(img.equals(""))) {
			File f = new File(filePath+"/"+img);
			f.delete();
		}
		
		request.setAttribute("result", result);
		
		return "/WEB-INF/views/board/deletePro.jsp";
	}
}