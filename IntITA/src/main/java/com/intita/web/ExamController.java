/**
 * @Author Sergey "yakudza" Tatarnikov 
 * @Date 30.02.2013
 * @Please Vinnitsa ITA
 * @Version 1.0
 *  
 */
package com.intita.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.intita.domain.Exam;
import com.intita.domain.ExamConnector;
import com.intita.domain.ExamResive;
import com.intita.domain.Group;
import com.intita.domain.Resiver;
import com.intita.domain.Role;
import com.intita.domain.Subject;
import com.intita.domain.User;
import com.intita.service.ExamService;
import com.intita.service.GroupService;
import com.intita.service.ResiverService;
import com.intita.service.ServiceLessons;
import com.intita.service.SubjectService;
import com.intita.service.UserService;

@Controller
public class ExamController {
	@Autowired
	private ExamService service;
	@Autowired
	private UserService userService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private ResiverService resiverService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ServiceLessons lessonsService;
	@Autowired
	private ExamService examService;
	private String typeUser;

	public ServiceLessons getLessonsService() {
		return lessonsService;
	}

	public void setLessonsService(ServiceLessons lessonsService) {
		this.lessonsService = lessonsService;
	}

	public ExamService getExamService() {
		return examService;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public ExamService getService() {
		return service;
	}

	public void setService(ExamService service) {
		this.service = service;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public ResiverService getResiverService() {
		return resiverService;
	}

	public void setResiverService(ResiverService resiverService) {
		this.resiverService = resiverService;
	}

	/**
	 * 
	 * 
	 */

	@RequestMapping(value = "/examGroup")
	public String listGroup(@ModelAttribute("group") Group group, Model model) {
		User user1 = userService.findByEmail(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		for (Role r : user1.getRoles()) {
			if (r.getName().equals("student")) {
				this.typeUser = "student";
			} else {
				this.typeUser = "teacher";
			}
		}
		if (typeUser.endsWith("teacher")) {
			List<ExamResive> lER = new ArrayList<ExamResive>();
			List<Exam> rezult = examService.readLessonType("exam");
			rezult.addAll(examService.readLessonType("offset"));
			for (Exam exam : rezult) {
				ExamResive obj = new ExamResive();
				Subject sub;
				sub = subjectService.readSubject(exam.getSubjectId());
				Group gro;
				gro = groupService.readGroup(exam.getGroupId());
				obj.setExams(exam);
				obj.setGroups(gro);
				obj.setSubjects(sub);
				lER.add(obj);
			}
			ExamConnector conn = new ExamConnector();
			model.addAttribute(conn);
			model.addAttribute("test", lER);
			return "examTeach";
		} else {
			model.addAttribute("resivers",
					resiverService.readExamById(user1.getUserId()));
			return "examStudent";
		}
	}

	@RequestMapping(value = "/examStatementList")
	public String StatementList(
			@ModelAttribute("examConnector") ExamConnector examConnector,
			Model model) {
		model.addAttribute("resiver", examConnector);
		return "examStatementList";
	}

	@RequestMapping(value = "/examTest", method = RequestMethod.POST)
	public String test(
			@ModelAttribute("examConnector") ExamConnector examConnector,
			Model model) {
		Group group = groupService.readGroup(examConnector.getGroupId());
		String time = examConnector.getTime().toString().replace(":", "_");
		File f = new File(examConnector.getType() + "/"
				+ examConnector.getSubjectName() + "/" + group.getName() + "/"
				+ time + "/" + examConnector.getStatement() + ".txt");
		if (f.exists()) {
			List<ExamConnector> userList = resiverService
					.readFromFile(examConnector);
			model.addAttribute("userList", userList);
			return "examShowPage";
		} else {
			List<Resiver> resiver = resiverService
					.readFromExamTable(examConnector);
			List<Resiver> resultList = new ArrayList<Resiver>();
			if (!resiver.isEmpty()) {
				for (Resiver resiverTemp : resiver) {
					if (!resiverTemp.getStatus().equals("close")) {
						resultList.add(resiverTemp);
					}
				}
				model.addAttribute("examConnector", examConnector);
				model.addAttribute("users", resultList);
				return "examFile";
			} else {
				ExamConnector resiverList = new ExamConnector();
				model.addAttribute("resiver", resiverList);
				model.addAttribute("examConnector", examConnector);
				List<User> users = userService
						.findByGroup(groupService.readGroup(examConnector.getGroupId()));
				model.addAttribute("users", users);
				return "examTEST";
			}
		}
	}

	@RequestMapping(value = "/examSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("resiver") ExamConnector examConnector,
			HttpServletRequest req, Model model) {
		try{
		
			String[] test=examConnector.getUserIdStr().split(",");
		}catch(Exception e)
		{
			return "redirect:/examGroup";
		}
		
		String status = new String();
		try {
			if (req.getParameterValues("status").equals("close"))
				System.out.println(req.getParameterValues("status"));
				status = "close";
				System.out.println("status  "+status);
		} catch (Exception e) {
			status = "open";
			
			System.out.println("exception "+status);
		}
		resiverService.parsAndSaveInDB(examConnector,status);
		return "redirect:/examGroup";
	}

	@RequestMapping(value = "/examShow")
	public String show(@ModelAttribute("resiver") Resiver examConn, Model model) {
		List<Resiver> examTable = new ArrayList<Resiver>();
		List<Resiver> temp = resiverService
				.readByGroupId(examConn.getGroupId());
		for (Resiver resiverTable : temp) {
			if (resiverTable.getSubjectName().equals(examConn.getSubjectName())
					&& resiverTable.getType().equals(examConn.getType())) {
				examTable.add(resiverTable);
			}
		}
		model.addAttribute("userList", examTable);
		return "examShowPage";
	}
}
