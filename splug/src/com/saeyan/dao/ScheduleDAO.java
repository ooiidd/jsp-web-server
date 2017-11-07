package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ScheduleVO;

import util.DBManager;

public class ScheduleDAO {
	private ScheduleDAO(){
	}
	private static ScheduleDAO instance = new ScheduleDAO();
	public static ScheduleDAO getInstance() {
		return instance;
	}
	
	public List<ScheduleVO> getDBList()
	{
		List<ScheduleVO> datas = new ArrayList<ScheduleVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from schedule";
		try
		{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) 
			{
				ScheduleVO schedule = new ScheduleVO();
				
				schedule.setS_year(rs.getInt("schedule_year"));
				schedule.setS_month(rs.getInt("schedule_month"));
				schedule.setS_day(rs.getInt("schedule_day"));
				schedule.setS_time(rs.getInt("schedule_time"));
				schedule.setS_title(rs.getString("schedule_title"));
				schedule.setS_content(rs.getString("schedule_content"));
				datas.add(schedule);	
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, stmt, rs);
		}
		return datas;
	}
	public boolean insert(ScheduleVO schedule)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="insert into schedule (schedule_year,schedule_month,schedule_day,schedule_time, schedule_title,schedule_content) values(?,?,?,?,?,?)";

		try 
		{			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, schedule.getS_year());
			pstmt.setInt(2, schedule.getS_month());
			pstmt.setInt(3, schedule.getS_day());
			pstmt.setInt(4, schedule.getS_time());
			pstmt.setString(5, schedule.getS_title());
			pstmt.setString(6, schedule.getS_content());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			DBManager.close(conn, pstmt);
		}

		return true;
	}
}
