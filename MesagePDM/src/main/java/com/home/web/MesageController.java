package com.home.web;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.data.Mesage;
import com.home.data.User;
import com.home.service.MesageServiceI;
import com.home.service.RoleServiceI;
import com.home.service.UserServiceI;

/**
 * Handles requests for the application add_post, all_post, all_my_post page.
 * 
 * @author Dmitriy Pyasetskiy
 */

@Controller
public class MesageController 
{
	@Autowired
	private UserServiceI userService;
	
	@Autowired
	private MesageServiceI mesageService;
	
	@Autowired
	private RoleServiceI roleService;
	
	public UserServiceI getUserService() {
		return userService;
	}

	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	public MesageServiceI getMesageService() {
		return mesageService;
	}

	public void setMesageService(MesageServiceI mesageService) {
		this.mesageService = mesageService;
	}
	
	public RoleServiceI getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleServiceI roleService) {
		this.roleService = roleService;
	}

	/**
	 * Handle aad post form new post.
	 * @param model
	 * @return form add post.
	 * ‘орма добавлени€ сообщени€
	 */
	@RequestMapping(value = "/add_post", method = RequestMethod.GET)
	public String addMesage(Model model)
	{ 	
		User user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		String formattedDate = dateFormat.format(date);
		model.addAttribute("mesage", new Mesage());
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("user", user);		
		return "/add_post";
	}
	
	/**
	 * Handle add post form new post.
	 * @param model
	 * @param mesage
	 * @param result
	 * @return form add post.
	 * ƒобавление сообщени€
	 */
	@RequestMapping(value = "/add_post", method = RequestMethod.POST)
	public String addMesageSubmit(Model model, @ModelAttribute("mesage") Mesage mesage, BindingResult result)
	{	 
		model.addAttribute("mesage", new Mesage());
		if (result.hasErrors()) return "/add_post";
		mesageService.addMesage(mesage);
		return "redirect:/add_post";
	}
	
	/**
	 * Handle all post user form all post user.
	 * @param model
	 * @return all post user.
	 * просмотр всех сообщений одного юзера.
	 */
	@RequestMapping(value = "/all_my_post", method = RequestMethod.GET)
	public String allMyPost(Model model)
	{
		User user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("user", user);
		model.addAttribute("mesages", mesageService.findByUserId(user.getUserId()));
		return "all_my_post";
	}
	
	/**
	 * Handle all post form all post.
	 * @param model
	 * @return all post.
	 * просмотр всех сообщений.
	 */
	@RequestMapping(value = "/all_post", method = RequestMethod.GET)
	public String allPost(Model model)
	{
		model.addAttribute("users", userService.readAllUser()); 
		model.addAttribute("mesages", mesageService.readAllMesage());
		return "all_post";
	}
	
	/**
	 * Handle delete post form all user post.
	 * @param mesageId
	 * @return all user post.
	 * удаление сообщени€.
	 */
	@RequestMapping("/all_my_post/{mesageId}")
	public String deletePost(@PathVariable("mesageId") Integer mesageId)
	{
		mesageService.deleteMesage(mesageId);
		return "redirect:/all_my_post";
	}
}
		
	

