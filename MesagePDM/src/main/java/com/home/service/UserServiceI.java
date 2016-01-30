package com.home.service;

import java.util.List;

import com.home.data.User;

/**
 * @author Dmitriy Pyasetskiy
 */

public interface UserServiceI 
{
	void addUser(User user);
	void updateUser(User user);
	User readUser(Integer userId);
	User findByEmail(String email);
	User findByRoleId(Integer roleId);
	List<User> readAllUser();
	void deleteUser(Integer userId);
	void deleteUser(User user);
}
