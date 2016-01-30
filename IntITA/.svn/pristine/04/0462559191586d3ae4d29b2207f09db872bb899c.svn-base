/**
 * 
 */
package com.intita.web;

/**
 * @author Barakuda
 *
 */

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intita.domain.LessonCalendar;
import com.intita.domain.NewLessons;
import com.intita.service.ServiceLessons;

@Controller
public class LessonController {

	@Autowired
	ServiceLessons service;


	public ServiceLessons getService() {
		return service;
	}

	public void setService(ServiceLessons service) {

		this.service = service;
	}

	@RequestMapping(value = "/enterData", method = RequestMethod.POST)
	public String select(@ModelAttribute("date") LessonCalendar date,
			Model model, BindingResult result, HttpServletRequest request) {
			int year = Integer.parseInt(date.getiSYear());
		int month = Integer.parseInt(date.getiSMonth());
		model.addAttribute("calendar", service.calendarWork(year, month));
		model.addAttribute("newLessons", new NewLessons());
		model.addAttribute("lessonsList", service.responseList(year, month + 1));
		return "lessons";
	}

	@RequestMapping("/lessons")
	public String testLessonController(Map<String, Object> model) {
		
		model.put("calendar", service.calendarWork(2013, 0));
		model.put("newLessons", new NewLessons());
		model.put("lessonsList", service.responseList(2013,1));
		model.put("date", new LessonCalendar());
		
		return "lessons";
	}

}
