package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.DatVO;

import util.DBManager;

public class DatDAO {
	private DatDAO() {
	}

	private static DatDAO instance = new DatDAO();

	public static DatDAO getInstance() {
		return instance;
	}

	public List<DatVO> selectAllDats(String table) {
		String sql = "select * from "+table+" order by num desc";
		List<DatVO> list = new ArrayList<DatVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DatVO bVo = new DatVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setBoardnum(rs.getInt("boardnum"));
				bVo.setUserid(rs.getString("userid"));
				bVo.setName(rs.getString("name"));
				bVo.setContent(rs.getString("content"));
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
	public List<DatVO> selectBoardDats(String table,String boardnum){
		String sql = "select * from "+table+" where boardnum="+boardnum;
		List<DatVO> list = new ArrayList<DatVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DatVO bVo = new DatVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setBoardnum(rs.getInt("boardnum"));
				bVo.setUserid(rs.getString("userid"));
				bVo.setName(rs.getString("name"));
				bVo.setContent(rs.getString("content"));
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
	public List<DatVO> selectSearchDats(String table,String where,String search) {
		String sql = "select * from "+table+" where "+where+" like '%"+search+"%'";
		List<DatVO> list = new ArrayList<DatVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DatVO bVo = new DatVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setBoardnum(rs.getInt("boardnum"));
				bVo.setUserid(rs.getString("userid"));
				bVo.setName(rs.getString("name"));
				bVo.setContent(rs.getString("content"));
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
	
	public List<DatVO> selectPartDats(String table,int start,int end){
		String sql = "select * from (select rownum no,num,boardnum,userid,name,content, "
				+"writedate from "+table+" order by num desc) "+table+
				" where no between "+String.valueOf(start)
				+" and "+String.valueOf(end)+" order by num desc";
		List<DatVO> list = new ArrayList<DatVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DatVO bVo = new DatVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setBoardnum(rs.getInt("boardnum"));
				bVo.setUserid(rs.getString("userid"));
				bVo.setName(rs.getString("name"));
				bVo.setContent(rs.getString("content"));
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
		List<DatVO> list = new ArrayList<DatVO>();
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

	public void insertDat(DatVO bVo,String table) {
		String sql = "insert into "+table+"("
				+ "num, boardnum, userid, name, content) "
				+ "values("+table+"_seq.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, bVo.getUserid());
			pstmt.setInt(1, bVo.getBoardnum());
			pstmt.setString(3, bVo.getName());
			pstmt.setString(4, bVo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateIkDat(DatVO bVo,String table){
		String sql = "update "+table+" set content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getContent());
			pstmt.setInt(2, bVo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//넘버로 삭제함 table 넘겨줘야됌.
	public void deleteDat(String num,String table) {
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
