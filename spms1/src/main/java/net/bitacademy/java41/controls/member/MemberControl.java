
package net.bitacademy.java41.controls.member;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/* @SessionAttributes("member")
 * 	- DispatcherServlet이 요청에 해당하는 페이지 컨트롤러의 메서드를 호출할 때,
 *   1) 파라미터 중에서 세션에 저장된 "member"와 같은 타입의 객체가 있다면 
 *   	새로 객체를 만들지 않고 기존 세션에 저장된 객체를 꼽어준다.
 */

@Controller
//@SessionAttributes("loginInfo")
@RequestMapping("/member")
public class MemberControl{
	@Autowired ServletContext sc;
	@Autowired
	MemberService memberService;
	long currTime = 0;
	int count = 0;
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", memberService.getMemberList());
		
		return "member/list";
	}	
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	protected String form() {
		return "member/newForm";
	}

	synchronized private String getNewFileName() {
		long millis = System.currentTimeMillis(); 
		if (currTime != millis) {
			currTime = millis;
			count = 0;
		}
		return "member_" + millis + "_" + (++count);
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	protected String add(Model model, Member member,MultipartFile photo) throws Exception {
		String filename = this.getNewFileName();
		String path = sc.getAttribute("rootRealPath") + "file/" + filename;
		photo.transferTo(new File(path));
		member.setPhotos(new String[]{filename});
		
		
		memberService.signUp(member);
		
		return "redirect:list.do";
	}
	

	@RequestMapping("/view")
	public String view(Model model, String email) throws Exception {
		model.addAttribute("memberInfo", memberService.getMember(email));
		return "member/view";
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.GET)
	public String updateForm(Model model, String email, HttpSession session) throws Exception {
		  model.addAttribute("memberInfo",memberService.getMember(email));
		  
		  return "member/updateMyInfo";
  			
  }


	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public String update(Model model, Member member, String password1, MultipartFile photo) throws Exception {
		Member member1 = memberService.get(member.getEmail());
		String password = member1.getPassword();
		if(password.equals(password1)){
			String filename = this.getNewFileName();
			String path = sc.getAttribute("rootRealPath") + "file/" + filename;
			photo.transferTo(new File(path));
			member.setPhotos(new String[]{filename});
			memberService.change(member);
			
		} else{
			return "member/viewfail";
		}
		return "member/viewsucess";


		

	}

	@RequestMapping("/delete")
	public String execute(Model model, String email) throws Exception {
		
		memberService.deleteMember(email);
		
		model.addAttribute("list", memberService.getMemberList());
		
		return "member/list";
		
	

	}
	
	@RequestMapping("/passwordChange")
	public String passwordChagne(Model model, String email, String password, String newPassword, String newPassword2) throws Exception {
		
		if (newPassword == null) {
			return form2();
		} else {
			if (newPassword.equals(newPassword2)) {
				if (memberService.changePassword(email, password, newPassword)) {
					model.addAttribute("status", "SUCCESS");
				} else {
					model.addAttribute("status", "OLD_PASSWORD_ERROR");
				}
			} else {
				model.addAttribute("status", "NEW_PASSWORD_ERROR");
			}
			
			return "member/passwordChangeResult";
		}
	}
	
	protected String form2() {
		return "member/passwordForm";
	}
	

}