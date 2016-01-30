package com.intita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intita.dao.RoleDAO;
import com.intita.domain.Role;

/**
 * @author Dmitriy Pyasetskiy
 */

@Service
public class RoleServiceImpl implements RoleService
{
	@Autowired
	private RoleDAO roleDAO;

	public RoleDAO getRoleDAO() 
	{
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) 
	{
		this.roleDAO = roleDAO;
	}

	@Transactional
	@Override
	public List<Role> readAll() 
	{
		return roleDAO.readAll();
	}

	@Transactional
	@Override
	public Role readRole(Integer roleId) 
	{
		return roleDAO.read(roleId);
	}

	@Transactional
	@Override
	public Role find(String name) 
	{
		return roleDAO.find(name);
	}
}
