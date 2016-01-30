package com.intita.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intita.domain.Group;
import com.intita.service.FoldersService;
import com.intita.service.GroupService;
import com.intita.service.UserService;

/**
 * @author Dmitriy Pyasetskiy
 */
@Controller
public class GroupController 
{
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private FoldersService foldersService;
	
	@Autowired
	private UserService userService;
	
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

	public FoldersService getFoldersService() {
		return foldersService;
	}

	public void setFoldersService(FoldersService foldersService) {
		this.foldersService = foldersService;
	}
	
	// Форма добавления группы
	@RequestMapping(value = "/groupadd", method = RequestMethod.GET)
	public String signup(ModelMap model) 
	{
		Group group = new Group();
		model.addAttribute("groups", groupService.readAll());
		model.put("group", group);
		return "groupadd";
	}

	//Добавление группы
	@RequestMapping(value = "/groupadd", method = RequestMethod.POST)
	public String processSignup(@Valid Group group, BindingResult result) 
	{
		if (result.hasErrors())
			return "groupadd";
		groupService.addGroup(group);
		foldersService.createFolders(group);
		return "redirect:/groupadd";
	}
	
	// Форма списка групп
	@RequestMapping(value = "/grouplist", method = RequestMethod.GET)
	public String listGroup(@ModelAttribute("group") Group group, Model model)
	{ 	
		model.addAttribute("groups", groupService.readAll());
		return "grouplist";
	}
	
	//Удаление группы
	@RequestMapping("/grouplist/{groupId}")
	public String deleteGroup(@PathVariable("groupId") Integer groupId)
	{ 	
		Group oldGroup = groupService.readGroup(groupId);
		userService.deleteAllUser(oldGroup);
		foldersService.deleteFolders(oldGroup);
		groupService.deleteGroup(groupId);
		return "redirect:/grouplist";
	}
}
