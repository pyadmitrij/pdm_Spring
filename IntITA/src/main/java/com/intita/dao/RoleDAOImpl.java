package com.intita.dao;

import org.springframework.stereotype.Repository;

import com.intita.domain.Role;

@Repository
public class RoleDAOImpl extends GenericDaoImpl<Role, Integer> implements RoleDAO
{

	@Override
	public Role find(String name) 
	{
		return (Role) currentSession().createQuery(
				"From Role where name = :name").setString("name", name).uniqueResult();
	}

}
