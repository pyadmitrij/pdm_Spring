package com.intita.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intita.dao.RoleDAO;
import com.intita.dao.UserDAO;
import com.intita.domain.Group;
import com.intita.domain.Role;
import com.intita.domain.User;

/**
 * @author Dmitriy Pyasetskiy
 */
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
    private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public UserDAO getUserDAO() 
	{
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) 
	{
		this.userDAO = userDAO;
	}

	@Transactional
	@Override
	public void addUser(User user) 
	{
		userDAO.create(user);
	}

	@Transactional
	@Override
	public User readUser(Integer userId) 
	{
		return userDAO.read(userId);
	}

	@Transactional
	@Override
	public User findByEmail(String email) 
	{ 
		return userDAO.findByEmail(email);
	}

	@Transactional
	@Override
	public List<User> readAllUser(Integer groupId) 
	{		
		return userDAO.readAll();
	}

	@Transactional
	@Override
	public void update(User user) 
	{
		userDAO.update(user);		
	}

	@Transactional
	@Override
	public void deleteUser(Integer userId)
	{
		userDAO.delete(userDAO.read(userId));
	}

	@Transactional
	@Override
	public List<User> findByUserRole(Integer roleId) 
	{
		String roleName = roleDAO.read(roleId).getName();
		List<User> teachers = new LinkedList<>();
		for(User u : userDAO.readAll())
			for(Role r : u.getRoles())
				if(r.getName().equals(roleName))
					teachers.add(u);
		return teachers;
	}

	@Transactional
	@Override
	public List<User> findByGroup(Group groupId) 
	{
		return userDAO.findByGroupId(groupId);
	}

	@Transactional
	@Override
	public void deleteUser(User user) 
	{
		userDAO.delete(user);
	}

	@Transactional
	@Override
	public void deleteAllUser(Group groupId) 
	{
		userDAO.deleteAllUser(groupId);
	}
}
