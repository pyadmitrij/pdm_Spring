/**
 * 
 */
package com.intita.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intita.domain.Group;
import com.intita.domain.Mark;
import com.intita.domain.Subject;
import com.intita.service.GroupService;
import com.intita.service.MarkService;
import com.intita.service.SubjectService;

/**
 * @author Alex
 *
 */
@Controller
public class MarkController {
	@Autowired
	MarkService service;
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	SubjectService subjectService;

	public MarkService getService() {
		return service;
	}

	public void setService(MarkService service) {
		this.service = service;
	}
	@RequestMapping("/stmark")
	public String testMark(Map<String, Object> model){
		
		Mark mark = new Mark();
		mark.setMark(5);
		//mark.setLessonId(2);
		mark.setUserId(5);
		mark.setDescription("lectoin");
		service.addMark(mark);
		mark = service.readMark(mark.getId());
		model.put("obj", mark);
		
		/*Mark object = new Mark();
		object.setMark(4);
		object.setLessonId(1);
		object.setUserId(1);
		service.addMark(object);
		object = service.readMark(object.getId());
		model.put("object", object);*/
		return "studentmarks";
	}
	
	@RequestMapping("/tmark")
	public String testMark1(Map<String, Object> model){
		
		Mark mark = new Mark();
		mark.setMark(4);
		mark.setLessonId(2);
		mark.setUserId(5);
		mark.setDescription("lectoin");
		service.addMark(mark);
		mark = service.readMark(mark.getId());
		model.put("obj", mark);
//		List name = service.readAll();
		List<Subject> subject = subjectService.readAll();
		model.put("subjects", subject);
		List<Group> groups = groupService.readAll();
		model.put("groups", groups);
		return "teachermarks";
	}

}
