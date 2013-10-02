package net.bitacademy.java41.controls.project;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/project")
public class ProjectControl {
	@Autowired ProjectService projectService;

	@RequestMapping("/list2")
	public String list(Model model) throws Exception {
		model.addAttribute("list", projectService.getProjectList());
		return "proeject/list";
	}


	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("project/list");
		mv.addObject("list", projectService.getProjectList());
		return mv;
	}

	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String form()  {
		return "project/newForm";
	}

	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(
			Project project,
			HttpSession session) throws Exception {
		Member member = (Member)session.getAttribute("member");
		project.setLeader(member.getEmail());

		projectService.addProject(project);

		return "redirect:list.do";
	}

	@RequestMapping("/view")
	public String view(int no,Model model) throws Exception {
		model.addAttribute("project", projectService.getProject(no));

		return "project/view";
	}
	@RequestMapping(value = "/update", method=RequestMethod.GET)
	public String updateForm(int no,Model model) throws Exception {
		model.addAttribute("projectInfo",projectService.getProject(no));

		return "project/updateForm";  
	}


	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public String execute(Project project,Model model) throws Exception {
		projectService.change(project);
		model.addAttribute("project", projectService.getProject(project.getNo()));
		return "project/view";		
	}

	@RequestMapping("/delete")
	public String delete(int level,int no,Model model) throws Exception {

		projectService.removeProject(no);
		model.addAttribute("list", projectService.getProjectList());

		if(level == 0){
			return "project/list";

		}else{
			return "project/list";
		}


	}
}

