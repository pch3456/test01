package net.bitacademy.java41.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.vo.Task;

public interface TaskDao {
	
	public List<Task> list(int no) throws Exception;
	
	public int add(HashMap<String,Object> paramMap) throws Exception;
	
	public Task get(int no) throws Exception;
	
	public void change(Task task) throws Exception;
	
	public void delete(int no) throws Exception;
	

	/*
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
	*/
	
}
