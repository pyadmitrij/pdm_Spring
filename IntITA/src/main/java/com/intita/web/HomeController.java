package com.intita.web;

import com.intita.domain.User;
import com.intita.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dmitriy Pyasetskiy
 */
@Controller
public class HomeController 
{
	@Autowired
	private UserService service;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	@RequestMapping
	public String start()
	{
		return "home";
	}
	
	@RequestMapping("/user")
	public String userPage(Map<String, Object> model, User user)
	{
		user = service.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		model.put("user", user);
		return "user";
	}
}
