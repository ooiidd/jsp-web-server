package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

import com.saeyan.dto.imgBoardVO;

public class imgBoardDAO {
	private imgBoardDAO() {
	}

	private static imgBoardDAO instance = new imgBoardDAO();

	public static imgBoardDAO getInstance() {
		return instance;
	}

	public List<imgBoardVO> selectAllBoards(String table) {
		String sql = "select * from "+table+" order by num desc";
		List<imgBoardVO> list = new ArrayList<imgBoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				imgBoardVO bVo = new imgBoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setUserid(rs.getString("userid"));
				bVo.setName(rs.getString("name"));
				bVo.setHakbun(rs.getString("hakbun"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setImg(rs.getString("img"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public List<imgBoardVO> selectSearchBoards(String table,String where,String search) {
		String sql = "select * from "+table+" where "+where+" like '%"+search+"%'";
		List<imgBoardVO> list = new ArrayList<imgBoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				imgBoardVO bVo = new imgBoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setUserid(rs.getString("userid"));
				bVo.setName(rs.getString("name"));
				bVo.setHakbun(rs.getString("hakbun"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setImg(rs.getString("img"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public List<imgBoardVO> selectPartBoards(String table,int start,int end){
		String sql = "select * from (select rownum no,num,userid,name,hakbun,title,content,"
				+"img,readcount,writedate from "+table+" order by num desc) "+table+
				" where no between "+String.valueOf(start)
				+" and "+String.valueOf(end)+" order by num desc";
		List<imgBoardVO> list = new ArrayList<imgBoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				imgBoardVO bVo = new imgBoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setUserid(rs.getString("userid"));
				bVo.setName(rs.getString("name"));
				bVo.setHakbun(rs.getString("hakbun"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setImg(rs.getString("img"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				list.add(bVo);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt,rs);
		}
		return list;
	}
	public int tableNumber(String table){
		int rowCount=0;
		String sql = "select count(*) from "+table;
		List<imgBoardVO> list = new ArrayList<imgBoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				rowCount=rs.getInt(1);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt,rs);
		}
		return rowCount;
	}

	public void insertBoard(imgBoardVO bVo,String table) {
		String sql = "insert into "+table+"("
				+ "num, userid, name, hakbun, title, content, img) "
				+ "values("+table+"_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getUserid());
			pstmt.setString(2, bVo.getName());
			pstmt.setString(3, bVo.getHakbun());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.setString(6, bVo.getImg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(String num,String table) {
		String sql = "update "+table+" set readcount=readcount+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
	public imgBoardVO selectOneBoardByNum(String num,String table) {
		String sql = "select * from "+table+" where num = ?";
		imgBoardVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = new imgBoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setUserid(rs.getString("userid"));
				bVo.setName(rs.getString("name"));
				bVo.setHakbun(rs.getString("hakbun"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setImg(rs.getString("img"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				bVo.setReadcount(rs.getInt("readcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}
	public void updateIkBoard(imgBoardVO bVo,String table){
		String sql = "update "+table+" set title=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getContent());
			pstmt.setInt(3, bVo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateBoard(imgBoardVO bVo,String table) {
		String sql = "update "+table+" set name=?, userid=? ,"
				+ "title=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getUserid());
			pstmt.setString(3, bVo.getTitle());
			pstmt.setString(4, bVo.getContent());
			pstmt.setInt(5, bVo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	//넘버로 삭제함 table 넘겨줘야됌.
	public void deleteBoard(String num,String table) {
		String sql = "delete "+table+" where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
