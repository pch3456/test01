package net.bitacademy.java41.controls.task;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.services.TaskService;

@Component("/task/list.do")
public class TaskListControl implements PageControl{
	TaskService taskService;
	ProjectService projectService;
	
	public TaskListControl setTaskService(TaskService taskService) throws Exception{
		this.taskService = taskService;
		return this;
	}
	
	public TaskListControl setProjectService(ProjectService projectService) {
		this.projectService = projectService;
		return this;
	}

	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		
		int no = Integer.parseInt(params.get("projectNo")[0]);
         
		model.put("projectInfo",projectService.get(no));
		model.put("list", taskService.getTaskList(no));
		return "/task/list.jsp";
	}

}
