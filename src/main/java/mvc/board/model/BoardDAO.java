package mvc.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	private BoardDAO() {}
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	private Connection getConn() throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl= "jdbc:oracle:thin:@localhost:1521:orcl";
			String user	= "scott";
			String pw	= "tiger";
			conn = DriverManager.getConnection(dburl, user, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
//	글 작성
	public int boardInsert(BoardDTO dto) {
		int result = 0;
		int num = dto.getNum();				// 글번호
		int ref = dto.getRef();				// 그룹번호
		int re_step = dto.getRe_step();
		int re_level = dto.getRe_level();
		int number = 0;						// 새로운 그룹번호
		try {
			conn = getConn();
			// 새 글인 경우, 중복되지 않은 새로운 그룹번호 필요함
			// 답글인 경우, 그룹번호 넘어옴
			sql = "select max(num) from board";	
			pstmt = conn.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = rs.getInt(1) + 1;	// 글이 이미 있는 경우, 첫 번째 인덱스 에서 1을 더해줌
			}else {
				number = 1;					// 새 글일 경우
			}
			
			if (num != 0) {					// 글 번호가 0이 아님 -> 답글인 경우
				sql = "update board set re_step = re_step+1 where ref=? and re_step>?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				re_step	+= 1;
				re_level+= 1;
			}else {
				ref = number;
				re_step = 0;
				re_level= 0;
			}
//			readCount (조회수)는 직접 입력 안함
			sql = "insert into board(num, writer, title, content, passwd, ref, re_step, re_level, reg, img) values(board_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, systimestamp, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, dto.getImg());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
//	글 개수
	public int boardCount() {
		int result = 0;
		try {
			conn = getConn();
			sql = "select count(*) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
//	내 글 개수
	public int boardMyCount(String id) {
		int result = 0;
		try {
			conn = getConn();
			sql = "select count(*) from board where writer=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
//	글 목록
	public ArrayList<BoardDTO> boardList(int start, int end) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>(end);
		try {
			conn = getConn();
			sql = "select * from (select b.*, rownum r from (select * from board order by ref desc, re_step asc) b) where r>=? and r<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReadCount(rs.getInt("readCount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setReg(rs.getTimestamp("reg"));
				dto.setImg(rs.getString("img"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
//	내글목록
	public ArrayList<BoardDTO> boardMyList(int start, int end, String id) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>(end);
		try {
			conn = getConn();
			sql = "select * from (select b.*, rownum r from (select * from board where writer=? order by ref desc) b) where r>=? and r<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReadCount(rs.getInt("readCount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setReg(rs.getTimestamp("reg"));
				dto.setImg(rs.getString("img"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
//	글 내용 + 조회수 증가
	public BoardDTO boardReadContent(int num) {
		BoardDTO dto = new BoardDTO();
		try {
			conn = getConn();
			sql = "update board set readCount=readCount+1 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			sql = "select * from board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReadCount(rs.getInt("readCount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));	
				dto.setRe_level(rs.getInt("re_level"));
				dto.setReg(rs.getTimestamp("reg"));
				dto.setImg(rs.getString("img"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return dto;
	}
	
//	글 정보
	public BoardDTO boardInfo(int num) {
		BoardDTO dto = new BoardDTO();
		try {
			conn = getConn();
			sql = "select * from board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setImg(rs.getString("img"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return dto;
	}
	
//	글 수정
	public int boardUpdate(BoardDTO dto) {
		int result = 0;
		String dbpw = "";
		try {
			conn = getConn();
			sql = "select passwd from board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbpw = rs.getString("passwd");
				if (dbpw.equals(dto.getPasswd())) {
					sql = "update board set title=?, content=?, passwd=?, img=? where num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dto.getTitle());
					pstmt.setString(2, dto.getContent());
					pstmt.setString(3, dto.getPasswd());
					pstmt.setString(4, dto.getImg());
					pstmt.setInt(5, dto.getNum());
					result = pstmt.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
//	글 삭제
	public int boardDelete(int num, String passwd) {
		int result = 0;
		String dbpw = "";
		try {
			conn = getConn();
			sql = "select passwd from board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbpw = rs.getString("passwd");
				if (dbpw.equals(passwd)) {
					sql = "delete from board where num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, num);
					result = pstmt.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
//	이미지 이름 가져오기
	public String imgName(int num) {
		String img = "";
		try {
			conn = getConn();
			sql = "select img from board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				img = rs.getString("img");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return img;
	}
}