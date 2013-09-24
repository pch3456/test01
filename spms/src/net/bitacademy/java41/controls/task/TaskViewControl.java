package net.bitacademy.java41.controls.task;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.services.TaskService;

@Component("/task/view.do")
public class TaskViewControl implements PageControl{
	TaskService taskService;
	ProjectService projectService;
	
	public TaskViewControl setTaskService(TaskService taskService){
		this.taskService = taskService;
		return this;
	}
	
	public TaskViewControl setProjectService(ProjectService projectService){
		this.projectService = projectService;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		int no = Integer.parseInt(params.get("no")[0]);
		int pno = Integer.parseInt(params.get("pno")[0]);
		
		model.put("task", taskService.getTask(no));
		model.put("projectInfo", projectService.getProject(pno));
		
		return "/task/view.jsp";
	}

}
