package net.bitacademy.java41.controls.member;

import java.io.File;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;

@Component("/member/updateMyInfo.do")
public class UpdatePostMyinfoControl implements PageControl {
	MemberService memberService;
	String rootRealPath;
	long currTime = 0;
	int count = 0;


	public UpdatePostMyinfoControl setMemberService(MemberService memberService) {
		this.memberService = memberService;
		return this;
	}
	
	public void setRootRealPath(String rootRealPath) {
		this.rootRealPath = rootRealPath;
	}


	@SuppressWarnings("unchecked")
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Map<String,Object> params = 
				(Map<String,Object>)model.get("params");
		
		FileItem photo = (FileItem)params.get("photo");
		String filename = this.getNewFileName();
		String path = rootRealPath + "file/" + filename;
		photo.write(new File(path));


		String serverpwd = (String)params.get("serverpwd");


		if(((String)params.get("password")).equals(serverpwd)){

			Member member = new Member()
			.setEmail((String)params.get("email"))
			.setName((String)params.get("name"))
			.setTel((String)params.get("tel"))
			.setBlog((String)params.get("blog"))
			.setDetailAddress((String)params.get("detailAddr"))
			.setTag((String)params.get("tag"))
			.setPhotos(new String[]{filename});

			memberService.change(member);

			return "/member/viewsucess.jsp";

		}else{
			return "/member/viewfail.jsp";

		}

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
