package com.home.dao;

import com.home.data.User;

/**
 * @author Dmitriy Pyasetskiy
 */

public interface UserDaoI extends GenericDaoI<User, Integer>
{
	
	User findByEmail(String email);
	
	User findByRoleId(Integer roleId);
	
	void deleteUser(Integer userId);
}
