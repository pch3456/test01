package net.bitacademy.java41.controls.task;

import java.io.File;
import java.sql.Date;
import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Task;

import org.apache.commons.fileupload.FileItem;

@Component("/task/update.do")
public class TaskPostUpdateControl implements PageControl{
	TaskService taskService;
	ProjectService projectService;
	String rootRealPath;
	long currTime = 0;
	int count = 0;
	
	public TaskPostUpdateControl setTaskService(TaskService taskService){
		this.taskService = taskService;
		return this;
	}
	
	public TaskPostUpdateControl setProjectService(ProjectService projectService){
		this.projectService = projectService;
		return this;
	}
	
	public void setRootRealPath(String rootRealPath) {
		this.rootRealPath = rootRealPath;
	}
	
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,Object> params = 
				(Map<String,Object>)model.get("params");
		
		FileItem UI = (FileItem)params.get("URL");
		String filename = this.getNewFileName();
		String path = rootRealPath + "file/" + filename;
		UI.write(new File(path));
		
		Task task = new Task()
					.setPno(Integer.parseInt((String)params.get("pno")))
					.setTno(Integer.parseInt((String)params.get("no")))
					.setTitle((String)params.get("name"))
					.setContext((String)params.get("content"))
					.setStartDate(Date.valueOf((String)params.get("startDate")))
					.setEndDate(Date.valueOf((String)params.get("endDate")))
					.setUIProtoURL(filename);
		
		taskService.change(task);

		int pno = task.getPno();
		model.put("list", taskService.getTaskList(pno));
		model.put("projectInfo",projectService.getProject(pno));
		return "/task/list.jsp";

	}

	private String getNewFileName() {
		long millis = System.currentTimeMillis(); 
		if (currTime != millis) {
			currTime = millis;
			count = 0;
		}
		return "member_" + millis + "_" + (++count);
	}
}
