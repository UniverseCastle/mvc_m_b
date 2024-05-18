package mvc.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDAO;
import mvc.board.model.BoardDTO;
import mvc.member.action.SuperAction;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.File;
import java.io.IOException;

public class UpdateProAction implements SuperAction {

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
		BoardDTO dto = new BoardDTO();
		try {
			MultipartRequest mr = new MultipartRequest(request, filePath, max, enc, dp);
			dto.setNum(Integer.parseInt(mr.getParameter("num")));
			dto.setTitle(mr.getParameter("title"));
			dto.setContent(mr.getParameter("content"));
			dto.setPasswd(mr.getParameter("passwd"));
			dto.setImg(mr.getFilesystemName("img"));
			
			String orgImg = mr.getParameter("orgImg");
			if (dto.getImg() == null) {
				dto.setImg(orgImg);
			}else {
				File f = new File(filePath+"/"+orgImg);
				f.delete();
			}
			
			BoardDAO dao = BoardDAO.getInstance();
			int result = dao.boardUpdate(dto);
			
			request.setAttribute("num", dto.getNum());
			request.setAttribute("result", result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/WEB-INF/views/board/updatePro.jsp";
	}
}