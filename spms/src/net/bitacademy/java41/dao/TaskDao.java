package net.bitacademy.java41.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Task;

@Component
public class TaskDao {
	DBConnectionPool conPool;

	public TaskDao setDBConnectionPool(DBConnectionPool conPool){
		this.conPool = conPool;
		return this;
	}
	
	public TaskDao(){}
	
	public TaskDao(DBConnectionPool conPool){
		this.conPool = conPool;
	}
	
	public List<Task> list(int no) throws Exception{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Task> list = new ArrayList<Task> ();
		
		try{
			con = conPool.getConnection();
			stmt= con.prepareStatement(
					"select PNO, TNO, TITLE, UIPROTOURL, CONTENT, START_DATE, END_DATE" +
					" from SPMS_TASKS" +
					" where PNO = ? " +
					" order by TNO asc");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				list.add(new Task()
						.setPno(rs.getInt("PNO"))
						.setTno(rs.getInt("TNO"))
						.setTitle(rs.getString("TITLE"))
						.setContext(rs.getString("CONTENT"))
						.setStartDate(rs.getDate("START_DATE"))
						.setEndDate(rs.getDate("END_DATE")));
			}
			
			return list;
			
		} catch(Exception e){
			throw e;
		} finally{
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
	
	
	public int add(Task task, Connection transactionConnection, String path) throws Exception {
		Connection con = null;
		PreparedStatement taskStmt = null;
		PreparedStatement taskMemberStmt = null;
		ResultSet rs = null;

		try {
			con = transactionConnection;
			taskStmt = con.prepareStatement(
					"insert into SPMS_TASKS("
					+ " TITLE, UIPROTOURL, CONTENT, START_DATE, END_DATE, PNO)"
					+ " values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			taskStmt.setString(1, task.getTitle());
			taskStmt.setString(2, path);
			taskStmt.setString(3, task.getContext());
			taskStmt.setDate(4, task.getStartDate());
			taskStmt.setDate(5, task.getEndDate());
			taskStmt.setInt(6, task.getPno());
			taskStmt.executeUpdate();
			
			rs = taskStmt.getGeneratedKeys();
			if(rs.next()){
				task.setTno(rs.getInt(1));
			}
			
			taskMemberStmt = con.prepareStatement(
					"insert into SPMS_MEMBTASK("
					+ " TNO, EMAIL, PNO)"
					+ " values(?,?,?)");
			taskMemberStmt.setInt(1,task.getTno());
			taskMemberStmt.setString(2,task.getEmail());
			taskMemberStmt.setInt(3,task.getPno());
			taskMemberStmt.executeUpdate();
			
			return task.getTno();
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {rs.close();} catch(Exception e) {}
			try {taskStmt.close();} catch(Exception e) {}
			try {taskMemberStmt.close();} catch(Exception e) {}
		}
	}
	
	public Task get(int no) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
					"select PNO, TITLE, UIPROTOURL, CONTENT, START_DATE, END_DATE, TNO" +
					" from SPMS_TASKS"
					+ " where TNO = ?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return new Task()
							.setPno(rs.getInt("PNO"))
							.setTno(rs.getInt("TNO"))
							.setTitle(rs.getString("TITLE"))
							.setUIProtoURL(rs.getString("UIPROTOURL"))
							.setContext(rs.getString("CONTENT"))
							.setStartDate(rs.getDate("START_DATE"))
							.setEndDate(rs.getDate("END_DATE"));
			} else {
				return null;
			}
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
	
	public int change(Task task) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"update SPMS_TASKS set"
				+ " TITLE=?,CONTENT=?,"
				+ " START_DATE=?,END_DATE=?,UIPROTOURL=?"
				+ " where TNO=?");
			stmt.setString(1, task.getTitle());
			stmt.setString(2, task.getContext());
			stmt.setDate(3, task.getStartDate());
			stmt.setDate(4, task.getEndDate());
			stmt.setString(5, task.getUIProtoURL());
			stmt.setInt(6, task.getTno());
			return stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
	
	public int delete(int no) throws Exception{
		Connection con = null;
		PreparedStatement stmt= null;
		
		try{
			con = conPool.getConnection();
			stmt = con.prepareStatement(
					"delete from SPMS_TASKS" +
					" where TNO = ?");
			stmt.setInt(1, no);
			
			return stmt.executeUpdate();
			
		} catch(Exception e){
			throw e;
		} finally{
			try{stmt.close();} catch(Exception e) {}
			if(con != null){
				conPool.returnConnection(con);
			}
		}
	}
	
	public int deleteMtask(int no) throws Exception{
		Connection con = null;
		PreparedStatement stmt= null;
		
		try{
			con = conPool.getConnection();
			String sql = "delete from SPMS_MEMBTASK" +
					" where TNO = ?";
			stmt = con.prepareStatement(
					sql);
			stmt.setInt(1, no);
			
			return stmt.executeUpdate();
			
		} catch(Exception e){
			throw e;
		} finally{
			try{stmt.close();} catch(Exception e) {}
			if(con != null){
				conPool.returnConnection(con);
			}
		}
	}
	
	public int deleteMtaskByPno(int pno,Connection transactionConnection) throws Exception{
		Connection con = null;
		PreparedStatement stmt= null;
		
		try{
			con = transactionConnection;
			String sql = "delete from SPMS_MEMBTASK" +
					" where PNO = ?";
			stmt = con.prepareStatement(
					sql);
			stmt.setInt(1, pno);
			
			return stmt.executeUpdate();
			
		} catch(Exception e){
			throw e;
		} finally{
			try{stmt.close();} catch(Exception e) {}
			if(con != null){
				conPool.returnConnection(con);
			}
		}
	}
	
	public int deleteTaskByPno(int pno,Connection transactionConnection) throws Exception{
		Connection con = null;
		PreparedStatement stmt= null;
		
		try{
			con = transactionConnection;
			String sql = "delete from SPMS_TASKS" +
					" where PNO = ?";
			stmt = con.prepareStatement(
					sql);
			stmt.setInt(1, pno);
			
			return stmt.executeUpdate();
			
		} catch(Exception e){
			throw e;
		} finally{
			try{stmt.close();} catch(Exception e) {}
			if(con != null){
				conPool.returnConnection(con);
			}
		}
	}
	
	
	public void addPhoto(String email, String path) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"insert into SPMS_MEMIMG(EMAIL,IMGURL)"
				+ " values(?,?)");
			stmt.setString(1, email);
			stmt.setString(2, path);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null && con.getAutoCommit()) {
				conPool.returnConnection(con);
			}
		}
	}
	
}
