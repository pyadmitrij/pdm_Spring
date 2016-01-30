/**
 * 
 */
package com.intita.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import scheduleAlgorithmCPU.HungarianAlgorithm;
import com.intita.domain.NewLessons;
import com.intita.service.ServiceNewSchedule;
import com.intita.service.ServiceSchedule;

/**
 * @author Barakuda
 *
 */
@Controller
public class NewScheduleController {

	@Autowired
	ServiceNewSchedule service;
		
	public ServiceNewSchedule getService() {
		return service;
	}

	public void setService(ServiceNewSchedule service) {
		this.service = service;
	}

//	@RequestMapping("/newschedule")
//	public String sheduleController(Map<String,Object> model) {
////		   int[][] matrix = {{0,0,0,0,0,},{0,1,7,1,3}, {0,1,6,4,6}, {0,17,1,5,1}, {0,1,6,10,4}};
////		   a.algorithmCPU( matrix);
//		model.put("calendar",service.calendarWork(2013,0));
//		//  model.put("newLessons",new NewLessons());	
//		  // model.put("lessonsList",service.responseList(2013,0));	
//		return"newschedule";
//	} 
	
	 @RequestMapping("/newschedule")
	   	public String newlesson(Map<String,Object> model) {
//	    	model.put("groups",service.creatlistGroup());
//			 model.put("classrooms",service.creatlistClassrooms());	
//			  model.put("teachers",service.creatlistTeachers());
//			   model.put("subjects",service.creatlistSubjects());
//			    model.put("newLessons", new NewLessons());
	   		return"newschedule";
	 }
	
	@RequestMapping("/newclassroom")
	public String newClassroomController(Map<String,Object> model) {

		return"newclassroom";
	} 
	
	@RequestMapping("/newsubject")
	public String newSubjectController(Map<String,Object> model) {

		return"newsubject";
	} 
	
	@RequestMapping("/newtime")
	public String newTimeController(Map<String,Object> model) {

		return"newtime";
	} 

}
