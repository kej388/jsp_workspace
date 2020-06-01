package com.eunjinkoh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eunjinkoh.dto.BenVO;
import com.eunjinkoh.dto.BoardVO;
import com.eunjinkoh.dto.ReplyVVO;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {};
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	// 최근 등록한 게시글이 먼저 나오도록 게시글 목록
	/*public List<BoardVO> selectAllBoards() {
		String sql = "SELECT * FROM board ORDER BY num DESC";
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				list.add(bVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}*/
	
	public List<BoardVO> selectAllBoards(int pageno) {
		System.out.println(pageno);
		String sql="select  X.*"
				+ "	from ( "
				+ "	    select rownum as rnum, A.*"
				+ "	    from ("
				+ " 	        select *"
				+ "		        from board"
				+ "		        order by num"
				+ "	        ) A"
				+ "	    where rownum <= ?) X"
				+ "	where X.rnum >= ?";
		
		List<BoardVO> list=new ArrayList<BoardVO>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pageno*10);
			pstmt.setInt(2, (pageno-1)*10+1);
			rs=pstmt.executeQuery();
			while(rs.next()){
				//VO에 먼저 저장
				BoardVO bVo=new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				//List에 추가
				list.add(bVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
				
		return list;
	}
	
	// 전달인자로 받은 VO객체를 board 테이블에 삽입
	public void insertBoard(BoardVO bVo) {
		String sql = "INSERT INTO board("
				+ "num, name, email, pass, title, content)"
				+ "VALUES(board_seq.nextval, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			
			pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// ben 테이블에서 금칙어가 있는지를 확인하고 BenVO로 얻음
	public BenVO isBenName(String name) {
		String sql = "SELECT b_name FROM ben WHERE b_name=?";
		
		BenVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bVo = new BenVO();
				bVo.setName(rs.getString("b_name"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}
	
	// board 테이블에서 게시글 번호로 해당 게시글을 찾아 게시글 정보를 BoardVO객체로 얻음
	public BoardVO selectOneBoardByNum(String num) {
		String sql = "SELECT * FROM board WHERE num=?";
		
		BoardVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setEmail(rs.getString("email"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}
	
	// reply 테이블에서 해당 번호로 해당 글을 찾아 글 정보를 ReplyVVO객체로 얻음
		public ReplyVVO selectOneReplyByNum(String num) {
			String sql = "SELECT * FROM reply WHERE no=?";
			
			ReplyVVO rVo = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, num);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					rVo = new ReplyVVO();
					
					rVo.setNo(rs.getInt("no"));
					rVo.setpNum(rs.getInt("pNum"));
					rVo.setName(rs.getString("name"));
					rVo.setPassword(rs.getString("password"));
					rVo.setContent(rs.getString("content"));
					rVo.setWritedate(rs.getTimestamp("writedate"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return rVo;
		}
	
	// 조회수 증가
	public void updateReadCount(String num) {
		String sql = "UPDATE board SET readcount=readcount+1 WHERE num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	public void updateBoard(BoardVO bVo) {
		String sql = "UPDATE board SET name=?, email=?, pass=? "
				+ "title=?, content=? WHERE num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.setInt(6, bVo.getNum());
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void deleteBoard(String num) {
		String sql = "DELETE board WHERE num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 전체글수
	public int selectCountBoard(){
		String sql="select count(*) as recordCount from board";
		
		BoardVO bVo=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		int recordCount=0;
		try{
			conn=DBManager.getConnection();
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				recordCount=rs.getInt("recordCount");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return recordCount; //VO를 리턴
		
	}
	
	// 댓글 등록 insert
	public void insertReply(ReplyVVO rVo) {
		String sql = "insert into reply(no, pNum, name, password, content)"
				+ "values(reply_seq.nextval, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rVo.getpNum());
			pstmt.setString(2, rVo.getName());
			pstmt.setString(3, rVo.getPassword());
			pstmt.setString(4, rVo.getContent());
			pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	// reply 전체 레코드를 조회
	public List<ReplyVVO> selectAllReply(int pNum) {
		String sql = "select * from reply where pNum = ? order by no";
		List<ReplyVVO> list = new ArrayList<ReplyVVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyVVO rVo = new ReplyVVO();
				rVo.setNo(rs.getInt("no"));
				rVo.setpNum(rs.getInt("pNum"));
				rVo.setName(rs.getString("name"));
				rVo.setWritedate(rs.getTimestamp("writedate"));
				rVo.setContent(rs.getString("content"));
				list.add(rVo);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return list;
	}
	
	
	// reply 수정 
	public void updateReply(ReplyVVO rVo) {
		String sql = "UPDATE reply SET name=?, password=?, "
				+ "content=? WHERE no=? and pNum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rVo.getName());
			pstmt.setString(2, rVo.getPassword());
			pstmt.setString(3, rVo.getContent());
			pstmt.setInt(4, rVo.getNo());
			pstmt.setInt(5, rVo.getpNum());
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void deleteReply(String no) {
		String sql = "DELETE reply WHERE no=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
