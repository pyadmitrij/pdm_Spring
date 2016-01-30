package com.home.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.service.RoleServiceI;
import com.home.service.UserServiceI;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController 
{
	@Autowired
	private UserServiceI userService; 
	
	@Autowired
	private RoleServiceI roleService;
	
	public UserServiceI getUserServic() {
		return userService;
	}

	public void setUserServic(UserServiceI userService) {
		this.userService = userService;
	}
	
	public RoleServiceI getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleServiceI roleService) {
		this.roleService = roleService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
}
