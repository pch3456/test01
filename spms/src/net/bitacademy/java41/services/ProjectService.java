package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

@Component
public class ProjectService {
	ProjectDao projectDao;
	TaskDao taskDao;
	DBConnectionPool dbPool;
	MemberDao memberDao;
	
	public ProjectService setTaskDao(TaskDao taskDao){
		this.taskDao = taskDao;
		return this;
	}
	
	public ProjectService setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	public ProjectService setDBConnectionPool(DBConnectionPool dbPool) {
		this.dbPool = dbPool;
		return this;
	}
	
	public List<Project> getProjectList() throws Exception {
		return projectDao.list();
	}
	
	public List<MemberProject> getMyProjects(String email) throws Exception {
		return projectDao.listByMember(email);
	}
	
	public Project getProject(int no) throws Exception {
		return projectDao.get(no);
	}
	
	
	public void addProject(Project project) throws Exception {
		try {
			projectDao.add(project);
		} catch (Exception e) {
			throw e;
		} finally {
		}
		
	}
	
	public void removeProject(int no) throws Exception {
		try {
			projectDao.delete(no);
		} catch (Exception e) {
			throw e;
			
		} finally {
		}
		
	}

	public void change(Project project) throws Exception {
		projectDao.change(project);
	}
}













