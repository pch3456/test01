package net.bitacademy.java41.controls;

import net.bitacademy.java41.services.AuthService;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.LoginInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loginInfo")
public class SidebarControl {
	@Autowired AuthService authService;
	@Autowired ProjectService projectService;
	
	@RequestMapping("/sidebar")
	public String execute(LoginInfo loginInfo, Model model) throws Exception {
		model.addAttribute("loginInfo", authService.getLoginInfo(loginInfo.getLogEmail(), loginInfo.getPassword()));
		model.addAttribute("myProjects", projectService.getMyProjects(loginInfo.getLogEmail()));
		
		return "sidebar";
	}
}
