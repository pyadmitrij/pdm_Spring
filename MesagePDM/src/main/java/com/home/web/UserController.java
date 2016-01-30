package com.home.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.data.User;
import com.home.service.RoleServiceI;
import com.home.service.UserServiceI;

/**
 * Handles requests for the application add_user, user page.
 * 
 * @author Dmitriy Pyasetskiy
 */

@Controller
public class UserController 
{
	@Autowired
	private UserServiceI userService;
	
	@Autowired
	private RoleServiceI roleService;

	public RoleServiceI getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleServiceI roleService) {
		this.roleService = roleService;
	}

	public UserServiceI getUserService() {
		return userService;
	}

	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	
	/**
	 * Handle add user form new user.
	 * @param model
	 * @return form add user.
	 * Форма добавления пользователя
	 */
	@RequestMapping(value = "/add_user", method = RequestMethod.GET)
	public String addUser(ModelMap model)
	{ 	
		model.addAttribute("user", new User());
		model.addAttribute("role", roleService.readRole(1));
		return "add_user";
	}
	
	/**
	 * Handle add user form new user.
	 * @param model
	 * @param user
	 * @param request
	 * @param result
	 * @return form add user.
	 * Добавление пользователя
	 */
	@RequestMapping(value = "/add_user", method = RequestMethod.POST)
	public String addUserSubmit(Model model, @Valid User user, HttpServletRequest request,
			BindingResult result)
	{	
		model.addAttribute("user", new User());
		model.addAttribute("role", roleService.readRole(1));
		if(result.hasErrors()) return "add_user";
		userService.addUser(user);
		model.addAttribute("addeduser", user);
		return "/add_user";
	}
		
	/**
	 * Handle information user form information user.
	 * @param model
	 * @param user
	 * @return form user.
	 * Просмотр информации пользователя.
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage(Map<String, Object> model, User user)
	{
		user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		model.put("user", user);
		return "user";
	}
}
