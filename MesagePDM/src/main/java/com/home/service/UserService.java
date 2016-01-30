package com.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.dao.RoleDaoI;
import com.home.dao.UserDaoI;
import com.home.data.User;

/**
 * @author Dmitriy Pyasetskiy
 */

@Service
public class UserService implements UserServiceI
{

	@Autowired
	private UserDaoI userDAO;
	
	@Autowired
	private RoleDaoI roleDAO;
	
	public RoleDaoI getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDaoI roleDAO) {
		this.roleDAO = roleDAO;
	}

	public UserDaoI getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDaoI userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * Save instance of User into database.
	 * @param user new instance of User.
	 * @see User
	 */
	@Transactional
	@Override
	public void addUser(User user) {
		userDAO.create(user);		
	}

	/**
	 * Update instance of User from database.
	 * @param user update instanse of User.
	 * @see User
	 */
	@Transactional
	@Override
	public void updateUser(User user) {
		userDAO.update(user);
	}

	/**
	 * Read instance of User from database
	 * @param userId primary key.
	 * @return instance of user.
	 * @see User
	 */
	@Transactional
	@Override
	public User readUser(Integer userId) {
		return userDAO.read(userId);
	}

	/**
	 * Find user from database.
	 * @param email user.
	 * @return instance of User from database.
	 */
	@Transactional
	@Override
	public User findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

	/**
	 * Read list instance of User from database.
	 * @return list instance of user.
	 * @see User
	 */
	@Transactional
	@Override
	public List<User> readAllUser() {
		return userDAO.readAll();
	}

	/**
	 * Delete user from database.
	 * @param userId delete instanse of User.
	 */
	@Transactional
	@Override
	public void deleteUser(Integer userId) {
		userDAO.delete(userDAO.read(userId));
	}

	/**
	 * Delete user from database.
	 * @param user delete instanse of User.
	 */
	@Transactional
	@Override
	public void deleteUser(User user) {
		userDAO.delete(user);		
	}

	/**
	 * Find user from database.
	 * @param roleID user.
	 * @return instance of User from database.
	 */
	@Transactional
	@Override
	public User findByRoleId(Integer roleId) {
		return userDAO.read(roleId);
	}
}
