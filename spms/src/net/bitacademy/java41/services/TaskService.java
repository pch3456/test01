package net.bitacademy.java41.services;

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
		try {
			
			String photos = task.getUIProtoURL();
			taskDao.add(task, photos);
		} catch (Exception e) {
			throw e;
			
		} finally {
		}
	}
	
	
	public Task getTask(int no) throws Exception{
		return taskDao.get(no);
	}
	
	public void change(Task task) throws Exception{
		 taskDao.change(task);
	}
	
	public void deleteTask(int no) throws Exception{
		try{
			taskDao.delete(no);
		} catch(Exception e){
			throw e;
		} finally{
		}
	}
	
}
