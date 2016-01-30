package com.intita.dao;

import java.util.List;

import com.intita.domain.Group;
import com.intita.domain.User;

/**
 * @author Dmitriy Pyasetskiy
 */

public interface UserDAO extends GenericDao<User, Integer>
{
	User readUser(Integer userId);
	User findByEmail(String email);
	List<User> findByGroupId(Group groupId);
	User findByRoleId(Integer roleId);
	void deleteUser(Integer userId);
	void deleteAllUser(Group groupId);
}
