package net.bitacademy.java41.controls.member;

import java.io.File;
import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;

import org.apache.commons.fileupload.FileItem;

@Component("/member/add.do")
public class MemberAddControl implements PageControl {
	MemberService memberService;
	String rootRealPath;
	long currTime = 0;
	int count = 0;
	
	public void setRootRealPath(String rootRealPath) {
		this.rootRealPath = rootRealPath;
		System.out.println(rootRealPath);
	}
	
	public MemberAddControl setMemberService(MemberService memberService) {
		this.memberService = memberService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		if (params.get("email") == null) {
			return form();
		} else {
			return add(model);
		}
	}	
	
	protected String form() {
		return "/member/newForm.jsp";
	}
	
	protected String add(Map<String,Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,Object> params = 
				(Map<String,Object>)model.get("params");
		
		FileItem photo = (FileItem)params.get("photo");
		String filename = this.getNewFileName();
		String path = rootRealPath + "file/" + filename;
		photo.write(new File(path) );
		
		memberService.signUp(new Member()
					.setEmail((String)params.get("email"))
					.setName((String)params.get("name"))
					.setPassword((String)params.get("password"))
					.setTel((String)params.get("tel"))
					.setBlog((String)params.get("blog"))
					.setDetailAddress((String)params.get("detailAddr"))
					.setTag((String)params.get("tag"))
					.setLevel(Integer.parseInt((String)params.get("level")))
					.setPhotos(new String[]{filename}));
		
		return "redirect:list.do";
	}
	
	synchronized private String getNewFileName() {
		long millis = System.currentTimeMillis(); 
		if (currTime != millis) {
			currTime = millis;
			count = 0;
		}
		return "member_" + millis + "_" + (++count);
	}
}











