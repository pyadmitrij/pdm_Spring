/**
 * 
 */
package com.intita.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intita.domain.LessonCalendar;
import com.intita.domain.Lessons;
import com.intita.domain.NewLessons;
import com.intita.service.ServiceSchedule;
/**
 * @author Barakuda
 *
 */
@Controller
public class ScheduleController  {
	@Autowired
	ServiceSchedule service;
		
	
    @RequestMapping("/schedule")
	public String sheduleController(Map<String,Object> model) {
    	model.put("calendar", service.calendarWork(2013, 0));
		  model.put("newLessons", new NewLessons());
		    model.put("lessonsList", service.resList(2013,1));
		      model.put("date", new LessonCalendar());	
		return"schedule";
	} 
	
	@RequestMapping(value = "/newData", method = RequestMethod.POST)
	public String select(@ModelAttribute("date") LessonCalendar date,
			Model model, BindingResult result, HttpServletRequest request) {
			int year = Integer.parseInt(date.getiSYear());
		       int month = Integer.parseInt(date.getiSMonth());
		model.addAttribute("calendar", service.calendarWork(year, month));
		 model.addAttribute("newLessons", new NewLessons());
		  model.addAttribute("lessonsList", service.resList(year, month + 1));
		   model.addAttribute("date", new LessonCalendar());
       return "schedule";
	}
    
    @RequestMapping("/createlesson")
   	public String newlesson(Map<String,Object> model) {
    	model.put("groups",service.creatlistGroup());
		 model.put("classrooms",service.creatlistClassrooms());	
		  model.put("teachers",service.creatlistTeachers());
		   model.put("subjects",service.creatlistSubjects());
		    model.put("newLessons", new NewLessons());
   		return"createlesson";
   	} 
    
    @RequestMapping(value = "/addLesson", method = RequestMethod.POST)
	public String createLesson(@ModelAttribute("newLessons")NewLessons newlesson,Model model,
			BindingResult result, HttpServletRequest request){
    		 		  service.addLesson(newlesson);
       return "newData";
	}
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteLesson(@ModelAttribute("date")LessonCalendar date,Model model,
    	 BindingResult result, HttpServletRequest request) {
    	    	System.out.println(date.getId());  		
		//service.deleteLesson(5);//Integer.parseInt(date.getId()));
       return "schedule";
	}
   
  
    public ServiceSchedule getService() {
		return service;
	}

	public void setService(ServiceSchedule service) {
		this.service = service;
	}
		
}

