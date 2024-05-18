package mvc.board.action;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc.board.model.BoardDAO;
import mvc.board.model.BoardDTO;
import mvc.member.action.SuperAction;

public class WriteProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String filePath = request.getRealPath("resources/upload");
		int max = 1024 * 1024 * 5;
		String enc = "UTF-8";
		DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy();
		
		try {
			MultipartRequest mr = new MultipartRequest(request, filePath, max, enc, dp);
			BoardDTO dto = new BoardDTO();
			dto.setNum(Integer.parseInt(mr.getParameter("num")));
			dto.setWriter(mr.getParameter("writer"));
			dto.setTitle(mr.getParameter("title"));
			dto.setContent(mr.getParameter("content"));
			dto.setPasswd(mr.getParameter("passwd"));
			dto.setRef(Integer.parseInt(mr.getParameter("ref")));
			dto.setRe_step(Integer.parseInt(mr.getParameter("re_step")));
			dto.setRe_level(Integer.parseInt(mr.getParameter("re_level")));
			dto.setReg(new Timestamp(System.currentTimeMillis()));
			dto.setImg(mr.getFilesystemName("img"));
			
			BoardDAO dao = BoardDAO.getInstance();
			int result = dao.boardInsert(dto);
			request.setAttribute("result", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/WEB-INF/views/board/writePro.jsp";
	}
}