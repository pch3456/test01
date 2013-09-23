package net.bitacademy.java41.controls.task;

import java.io.File;
import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Task;

import org.apache.commons.fileupload.FileItem;

@Component("/task/add.do")
public class TaskAddControl implements PageControl{
	TaskService taskService;
	ProjectService projectService;
	String rootRealPath;
	long currTime = 0;
	int count = 0;
	
	public TaskAddControl setTaskServcie(TaskService taskService){
		this.taskService = taskService;
		return this;
	}
	
	public TaskAddControl setProjectService(ProjectService projectService) {
		this.projectService = projectService;
		return this;
	}
	
	public void setRootRealPath(String rootRealPath) {
		this.rootRealPath = rootRealPath;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		Member member = (Member)session.getAttribute("member");
		
		@SuppressWarnings("unchecked")
		Map<String,Object> params = (Map<String,Object>)model.get("params");
		
		FileItem UI = (FileItem)params.get("UIProtoURL");
		String filename = this.getNewFileName();
		String path = rootRealPath + "file/" + filename;
		UI.write(new File(path));
		
		int no = Integer.parseInt((String)params.get("no"));
		model.put("projectInfo",projectService.get(no));
		taskService.addTask(new Task()
						.setTitle((String)params.get("title"))
						.setUIProtoURL(filename)
						.setContext((String)params.get("content"))
						.setStartDate(Date.valueOf((String)params.get("startDate")))
						.setEndDate(Date.valueOf((String)params.get("endDate")))
						.setPno(Integer.parseInt(params.get("no").toString()))
						.setEmail(member.getEmail()));
		
		model.put("list", taskService.getTaskList(no));
		
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
