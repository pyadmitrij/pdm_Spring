package com.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.dao.RoleDaoI;
import com.home.data.Role;

/**
 * @author Dmitriy Pyasetskiy
 */

@Service
public class RoleService implements RoleServiceI
{
	
	@Autowired
	private RoleDaoI roleDao;
	
	public RoleDaoI getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDaoI roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * Read instance of Role from database
	 * @param roleId primary key.
	 * @return instance of role.
	 * @see Role
	 */
	@Transactional
	@Override
	public Role readRole(Integer roleId) {
		return roleDao.read(roleId);
	}

	/**
	 * Find Role from database.
	 * @param name role.
	 * @return instance of Role from database.
	 */
	@Transactional
	@Override
	public Role find(String name) {
		return roleDao.find(name);
	}

}
