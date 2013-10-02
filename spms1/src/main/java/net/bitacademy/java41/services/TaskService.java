package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.vo.Task;

public interface TaskService {
	 List<Task> getTaskList(int no) throws Exception;
	
	 void addTask(Task task) throws Exception;
	
	 Task getTask(int no) throws Exception;
	
	 void change(Task task) throws Exception;
	
	 void deleteTask(int no) throws Exception;
	
}
