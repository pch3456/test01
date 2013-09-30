package net.bitacademy.java41.services;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements TaskService{
	@Autowired
	TaskDao taskDao;
	@Autowired
	DBConnectionPool dbPool;
		
	public List<Task> getTaskList(int no) throws Exception{
		return taskDao.list(no);
	}
	
	@Transactional(
			propagation = Propagation.REQUIRED, 
			rollbackFor=Throwable.class)
	public void addTask(Task task) throws Exception {
		try {
			
			String photos = task.getUIProtoURL();
			HashMap<String,Object> paramMap = new HashMap<String,Object> ();
			paramMap.put("photos",photos);
			paramMap.put("task", task);
			taskDao.add(paramMap);
		} catch (Exception e) {
			throw e;
			
		} finally {
		}
	}
	
	
	public Task getTask(int no) throws Exception{
		return taskDao.get(no);
	}
	
	@Transactional(
			propagation = Propagation.REQUIRED, 
			rollbackFor=Throwable.class)
	public void change(Task task) throws Exception{
		 taskDao.change(task);
	}
	
	@Transactional(
			propagation = Propagation.REQUIRED, 
			rollbackFor=Throwable.class)
	public void deleteTask(int no) throws Exception{
		try{
			taskDao.delete(no);
		} catch(Exception e){
			throw e;
		} finally{
		}
	}
	
}
