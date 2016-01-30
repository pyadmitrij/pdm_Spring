package com.intita.web;

import com.intita.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dmitriy Pyasetskiy
 */
@Controller
public class Admin—ontroller 
{
	@Autowired
	private UserService service;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	@RequestMapping("/admin")
	public String start()
	{
		return "admin";
	}
}
