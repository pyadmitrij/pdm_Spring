package com.intita.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intita.domain.Group;
import com.intita.domain.Role;
import com.intita.domain.User;
import com.intita.service.FoldersService;
import com.intita.service.GroupService;
import com.intita.service.RoleService;
import com.intita.service.SubjectService;
import com.intita.service.UserService;

/**
 * @author Dmitriy Pyasetskiy
 */
@Controller
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private FoldersService foldersService;
	
	@Autowired 
	private GroupService groupService;
	
	@Autowired 
	private RoleService roleService;
	
	@Autowired 
	SubjectService subjectService;

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	// Форма добавления пользователя
	@RequestMapping(value = "/useradd", method = RequestMethod.GET)
	public String addUser(ModelMap model)
	{ 	
		model.addAttribute("user", new User());
		model.addAttribute("groups", groupService.readAll());
		model.addAttribute("roles", roleService.readAll());
		return "useradd";
	}
	
	// Добавление пользователя
	@RequestMapping(value = "/useradd", method = RequestMethod.POST)
	public String addUserSubmit(Model model, @Valid User user, HttpServletRequest request, 
			BindingResult result)
	{	
		model.addAttribute("user", new User());
		model.addAttribute("groups", groupService.readAll());
		model.addAttribute("roles", roleService.readAll());
		Role role = roleService.readRole(Integer.parseInt(request.getParameter("roleId")));
		if(role.getName().equals("student"))
		{
			Group group = groupService.readGroup(Integer.parseInt(request.getParameter("groupId")));
			user.setGroup(group);
		}
		if(result.hasErrors())
			return "useradd";
		user.getRoles().add(role);
		userService.addUser(user);
		foldersService.createFolders(user);
		model.addAttribute("addeduser", user);
		return "/useradd";
	}
	
	// Форма изминения информации пользователя
	@RequestMapping(value="/userupdate", method = RequestMethod.GET)
	public String infoUser(@ModelAttribute("userup") User user, Model model)
	{
		user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("user", user);
		return "userupdate";
	}
	
	// Обновление информации пользователя
	@RequestMapping(value = "/userupdate", method = RequestMethod.POST)
	public String updateUserOld(@Valid User user, BindingResult result)
	{
		User user1 = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		user.setUserId(user1.getUserId());
		user.setGroup(user1.getGroup());
		user.setEmail(user1.getEmail());
		user.setPassword(user1.getPassword());
		user.setName(user1.getName());
		user.setSurname(user1.getSurname());
		user.setAgreement(user1.getAgreement());
		user.setRoles(user1.getRoles());
		if(result.hasErrors())
			return "userupdate";
		userService.update(user);
		return "redirect:/user";
	}
	
	// Форма обновления пароля
	@RequestMapping(value="/userpass", method = RequestMethod.GET)
	public String userPass(@ModelAttribute("userpass") User user, Model model)
	{
		user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("user", user);
		return "userpass";
	}
	
	// Изминение пароля пользователя
	@RequestMapping(value = "/userpass", method = RequestMethod.POST)
	public String updateUserPass(@Valid User user, BindingResult result)
	{
		User user1 = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		user1.setPassword(user.getPassword());
		if(result.hasErrors())
			return "userpass";
		userService.update(user1);
		return "redirect:/user";
	}
	
	// Просмотр списка студентов в одной группе
	@RequestMapping(value = "/userlist/{groupId}", method = RequestMethod.GET)
	public String listUser(@PathVariable String groupId, Model model)
	{
//		System.out.println("Group "+groupId);
//		for(User user : userService.findByGroup(groupService.readGroup(Integer.parseInt(groupId))))
//			System.out.println(user.getName());
		model.addAttribute("group", groupService.readGroup(Integer.parseInt(groupId)));
		model.addAttribute("users", userService.findByGroup(groupService.readGroup(Integer.parseInt(groupId))));
		return "userlist";
	}
	
	// Просмотр списка преподавателей
	@RequestMapping(value = "/teacherlist", method = RequestMethod.GET)
	public String listTeacher(Model model)
	{ 	
		model.addAttribute("users", userService.findByUserRole(roleService.find("teacher").getRoleId()));
		return "teacherlist";
	}
	
	// Просмотр списка администраторров
	@RequestMapping(value = "/adminlist", method = RequestMethod.GET)
	public String listAdmin(Model model)
	{ 	
		model.addAttribute("users", userService.findByUserRole(roleService.find("admin").getRoleId()));
		return "adminlist";
	}
	
	//Удаление студента
	@RequestMapping("/userlist{userId}")
	public String deleteStudent(@PathVariable("userId") Integer userId)
	{ 	
		User user = userService.readUser(userId);
		int groupId = user.getGroup().getGroupId();
		foldersService.deleteFolders(user);
		userService.deleteUser(userId);
		return "redirect:/userlist/"+ groupId;
	}
	
	//Удаление преподавателя
	@RequestMapping("/teacherlist{userId}")
	public String deleteTeacher(@PathVariable("userId") Integer userId)
	{ 	
		foldersService.deleteFolders(userService.readUser(userId));
		subjectService.deleteAllSubject(userId);
		userService.deleteUser(userId);
		return "redirect:/teacherlist";
	}
	
	//Удаление админа
	@RequestMapping("/adminlist{userId}")
	public String deleteAdmin(@PathVariable("userId") Integer userId)
	{ 	
		userService.deleteUser(userId);
		return "redirect:/adminlist";
	}
}
