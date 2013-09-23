package net.bitacademy.java41.controls.task;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.services.TaskService;

@Component("/task/delete.do")
public class TaskDeleteControl implements PageControl{
	TaskService taskService;
	ProjectService projectService;
	
	public TaskDeleteControl setTaskService (TaskService taskService){
		this.taskService = taskService;
		return this;
	}
	
	public TaskDeleteControl setProjectService (ProjectService projectService){
		this.projectService = projectService;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = (Map<String,String[]>)model.get("params");
		
		int no = Integer.parseInt(params.get("no")[0]);
		int pno = Integer.parseInt(params.get("pno")[0]);
		
		taskService.deleteTask(no);
		model.put("projectInfo", projectService.get(pno));
		
		return "/task/list.do?projectNo=" + pno;
	}
	

}
