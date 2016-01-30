package com.intita.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intita.domain.Subject;
import com.intita.service.FoldersService;
import com.intita.service.SubjectService;
import com.intita.service.UserService;

/**
 * @author Dmitriy Pyasetskiy
 */
@Controller
public class SubjectController
{
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private FoldersService foldersService;
		
	public FoldersService getFoldersService() {
		return foldersService;
	}
	
	public void setFoldersService(FoldersService foldersService) {
		this.foldersService = foldersService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	// Список предметов у преподавателя
	@RequestMapping(value = "/sublist/{userId}", method = RequestMethod.GET)
	public String sublist(@PathVariable String userId, Model model)
	{
		model.addAttribute("subject", new Subject());
		model.addAttribute("user", userService.readUser(Integer.parseInt(userId)));
		model.addAttribute("subjects", subjectService.findBySubject(userService.readUser(Integer.parseInt(userId))));
//		for(Subject subject : subjectService.readAll())
//		{
//			System.out.println(subject.getUsersUserId());
//			System.out.println(subject.getSubjectName());
//		}
		return "sublist";
	}
	
	// Добавление предмета
	@RequestMapping(value = "/sublist/{userId}", method = RequestMethod.POST)
	public String addSubject(Model model, @PathVariable("userId") Integer userId,
			@ModelAttribute("subject")  Subject subject, BindingResult result)
	{
		if (result.hasErrors())
			return "sublist/{userId}";
		subjectService.addSubject(subject);
		foldersService.createFolders(subject);
		return "redirect:/sublist/"+userId;
	}
	
	// Удаление предмета
	@RequestMapping("/sublist{subjectId}")
	public String deleteSubject(@PathVariable("subjectId") Integer subjectId)
	{
		Subject oldSubject = subjectService.readSubject(subjectId);
		int uid = oldSubject.getUserId();
		foldersService.deleteFolders(oldSubject);
		subjectService.deleteSubject(subjectId);
		return "redirect:/sublist/"+uid;
	}
}
