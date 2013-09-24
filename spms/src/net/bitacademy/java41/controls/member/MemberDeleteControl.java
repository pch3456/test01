package net.bitacademy.java41.controls.member;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.MemberService;

@Component("/member/delete.do")
public class MemberDeleteControl implements PageControl {
	MemberService memberService;
	


	public MemberDeleteControl setMemberService(MemberService memberService) {
		this.memberService = memberService;
		return this;
	}



	@SuppressWarnings("unchecked")
	@Override
	public String execute(Map<String, Object> model) throws Exception {
				
				Map<String,String[]> params = 
							(Map<String,String[]>)model.get("params");        
		
				int level = Integer.parseInt(params.get("level")[0]);
				String email = params.get("email")[0];
				
				memberService.deleteMember(email);
				
				model.put("list", memberService.getMemberList());
				if(level == 0){
					return "/auth/LoginForm.jsp";
			
				}else{
					return "/member/list.jsp";
				}
			
		
			}
		}

	
