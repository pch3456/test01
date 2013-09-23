package net.bitacademy.java41.services;

import java.sql.Connection;
import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Task;

@Component
public class TaskService {
	TaskDao taskDao;
	DBConnectionPool dbPool;
	
	public TaskService setDBConnectionPool (DBConnectionPool dbPool){
		this.dbPool = dbPool;
		return this;
	}
	
	public TaskService setTaskDao(TaskDao taskDao){
		this.taskDao = taskDao;
		return this;
	}
	
	
	public List<Task> getTaskList(int no) throws Exception{
		return taskDao.list(no);
	}
	
	public void addTask(Task task) throws Exception {
		Connection con = dbPool.getConnection();
		con.setAutoCommit(false);
		try {
			
			String photos = task.getUIProtoURL();
			taskDao.add(task, con, photos);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
			
		} finally {
			con.setAutoCommit(true);
			dbPool.returnConnection(con);
		}
	}
	
	
	public Task getTask(int no) throws Exception{
		return taskDao.get(no);
	}
	
	public int change(Task task) throws Exception{
		return taskDao.change(task);
	}
	
	public void deleteTask(int no) throws Exception{
		Connection con = dbPool.getConnection();
		con.setAutoCommit(false);
		try{
			taskDao.deleteMtask(no);
			taskDao.delete(no);
			con.commit();
		} catch(Exception e){
			con.rollback();
			throw e;
		} finally{
			con.setAutoCommit(true);
			dbPool.returnConnection(con);
		}
	}
	
}
