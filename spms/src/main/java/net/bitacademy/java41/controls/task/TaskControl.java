package net.bitacademy.java41.controls.task;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/task")
public class TaskControl{
	@Autowired ServletContext sc;
	@Autowired TaskService taskService;
	@Autowired ProjectService projectService;
	long currTime = 0;
	int count = 0;

	@RequestMapping("/list")
	public String list(Model model, int projectNo) throws Exception {
		model.addAttribute("projectInfo",projectService.getProject(projectNo));
		model.addAttribute("list", taskService.getTaskList(projectNo));
		return "task/list";
	}

	@RequestMapping(value = "/add" , method=RequestMethod.GET)
	public String addForm(Model model, int projectNo) throws Exception {

		model.addAttribute("projectInfo",projectService.getProject(projectNo));

		return "task/newForm";
	}

	@RequestMapping(value = "/add" , method=RequestMethod.POST)
	public String add(Model model
			,HttpSession session
			,MultipartFile URL
			,Task task) throws Exception {
		Member member = (Member)session.getAttribute("member");

		String filename = this.getNewFileName();
		String path = sc.getAttribute("rootRealPath") + "file/" + filename;
		URL.transferTo(new File(path));
		task.setUIProtoURL(filename);	

		model.addAttribute("projectInfo",projectService.getProject(task.getPno()));

		task.setEmail(member.getEmail());
		taskService.addTask(task);

		model.addAttribute("list", taskService.getTaskList(task.getPno()));

		return "task/list";
	}


	@RequestMapping("/delete")
	public String delete(Model model, int pno, int no) throws Exception {

		taskService.deleteTask(no);
		model.addAttribute("projectInfo", projectService.getProject(pno));
		model.addAttribute("list", taskService.getTaskList(pno));
		return "task/list";
	}

	@RequestMapping("/view")
	public String view(Model model, int pno, int no) throws Exception {

		model.addAttribute("task", taskService.getTask(no));
		model.addAttribute("projectInfo", projectService.getProject(pno));

		return "task/view";
	}

	
	@RequestMapping(value = "/update", method=RequestMethod.GET)
	public String updateForm(Model model, int no) throws Exception {
          
		  model.addAttribute("taskInfo",taskService.getTask(no));

		  return "task/updateForm";
		
	}


	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public String update(Model model, MultipartFile URL,Task task) throws Exception {
		
		String filename = this.getNewFileName();
		String path = sc.getAttribute("rootRealPath") + "file/" + filename;
		URL.transferTo(new File(path));
		task.setUIProtoURL(filename);		
		
		taskService.change(task);

		int pno = task.getPno();
		model.addAttribute("list", taskService.getTaskList(pno));
		model.addAttribute("projectInfo",projectService.getProject(pno));
		return "task/list";

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
