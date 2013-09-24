package net.bitacademy.java41.controls.project;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;

@Component("/project/delete.do")
public class ProjectDeleteControl implements PageControl {
	ProjectService projectService;
	


	public ProjectDeleteControl setProjectService(ProjectService projectService) {
		this.projectService = projectService;
		return this;
	}



	@SuppressWarnings("unchecked")
	@Override
	public String execute(Map<String, Object> model) throws Exception {
				
				Map<String,String[]> params = 
							(Map<String,String[]>)model.get("params");        
		
				int level = Integer.parseInt(params.get("level")[0]);
				int no = Integer.parseInt(params.get("no")[0]);
				
				projectService.removeProject(no);
				model.put("list", projectService.getProjectList());
				
				if(level == 0){
					return "/project/list.jsp";
			
				}else{
					return "/project/list.jsp";
				}
			
		
			}
		}

	

