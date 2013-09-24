package net.bitacademy.java41.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.vo.Task;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@Component
public class TaskDao {
	SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public TaskDao(){}
	

	
	public List<Task> list(int no) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectList(
					"net.bitacademy.java41.dao.TaskMapper.list", no);
			
		} catch(Exception e){
			throw e;
		} finally{
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	
	public int add(Task task, String path) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert(
					"net.bitacademy.java41.dao.TaskMapper.add", task);
			
			sqlSession.commit();
			HashMap<String,Object> paramMap2 = new HashMap<String,Object> ();
			paramMap2.put("tno", task.getTno());
			paramMap2.put("email", task.getEmail());
			paramMap2.put("pno", task.getPno());
			sqlSession.insert(
					"net.bitacademy.java41.dao.TaskMapper.addMemberTask", paramMap2);
			
			sqlSession.commit();
			return task.getTno();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public Task get(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne("net.bitacademy.java41.dao.TaskMapper.get",no);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	public void change(Task task) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			 sqlSession.update(
					"net.bitacademy.java41.dao.TaskMapper.change", task);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public void delete(int no) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			sqlSession.delete(
					"net.bitacademy.java41.dao.TaskMapper.deleteMTask", no);
			 sqlSession.delete(
					"net.bitacademy.java41.dao.TaskMapper.delete", no);
			
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
			
		}
	}
	

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
