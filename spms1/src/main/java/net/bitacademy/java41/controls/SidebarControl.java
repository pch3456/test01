package net.bitacademy.java41.controls;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.AuthService;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.LoginInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes("loginInfo")
public class SidebarControl {
	@Autowired AuthService authService;
	@Autowired ProjectService projectService;
	
	@RequestMapping("/sidebar")
	public String execute(Model model, HttpSession session) throws Exception {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		model.addAttribute("loginInfo", authService.getLoginInfo(loginInfo.getLogEmail(), loginInfo.getLogPassword()));
		model.addAttribute("myProjects", projectService.getMyProjects(loginInfo.getLogEmail()));
		
		return "sidebar";
	}
}
