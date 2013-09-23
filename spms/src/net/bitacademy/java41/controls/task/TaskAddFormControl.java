package net.bitacademy.java41.controls.task;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;

@Component("/task/addForm.do")
public class TaskAddFormControl implements PageControl{
	ProjectService projectService;
    
	
	public TaskAddFormControl setProjectService(ProjectService projectService) {
		this.projectService = projectService;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		
		  int no = Integer.parseInt(params.get("projectNo")[0]);
          
		  
		  model.put("projectInfo",projectService.get(no));

		  return "/task/newForm.jsp";
	  		
	  
   }
	
	
}
