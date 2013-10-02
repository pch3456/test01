package net.bitacademy.java41.controls.feed;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.FeedService;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.Feed;
import net.bitacademy.java41.vo.LoginInfo;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/feed")
public class FeedControl {
	@Autowired FeedService feedService;
	@Autowired ProjectService projectService;

	@RequestMapping("/list")
	public String list(Model model, int projectNo) throws Exception {

		model.addAttribute("projectInfo",projectService.getProject(projectNo));
		model.addAttribute("list", feedService.getFeedList(projectNo));

		return "feed/list";
	}

	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(
			Feed feed,
			HttpSession session) throws Exception {
		LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
		String email = loginInfo.getEmail();
		feed.setEmail(email);

		feedService.addFeed(feed);

		return "redirect:list.do?projectNo=" + feed.getPno();
	}

	@RequestMapping("/delete")
	public String delete(Model model, int fno, int pno) throws Exception {
		
		System.out.println(fno);
		feedService.deleteFeed(fno);
		
		return "redirect:list.do?projectNo=" + pno;
	}
}
