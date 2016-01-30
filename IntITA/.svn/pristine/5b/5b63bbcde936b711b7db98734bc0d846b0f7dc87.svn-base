package com.intita.service;

import java.util.List;

import com.intita.domain.Group;
import com.intita.domain.User;

/**
 * @author Dmitriy Pyasetskiy
 */
public interface UserService 
{
	void addUser(User user);
	void update(User user);
	User readUser(Integer userId);
	User findByEmail(String email);
	List<User> findByGroup(Group groupId);
	List<User> findByUserRole(Integer roleId);
	List<User> readAllUser(Integer groupId);
	void deleteUser(Integer userId);
	void deleteUser(User user);
	void deleteAllUser(Group groupId);
}
