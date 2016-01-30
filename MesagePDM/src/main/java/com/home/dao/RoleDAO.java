package com.home.dao;

import org.springframework.stereotype.Repository;

import com.home.data.Role;

/**
 * RoleDAO implements interaction between Role entity and database
 * @author Dmitriy Pyasetskiy
 */

@Repository
public class RoleDAO extends GenericDAO<Role, Integer> implements RoleDaoI
{

	/**
	 * Поиск роли пользоваьеля
	 * @param name имя роли
	 */
	@Override
	public Role find(String name) 
	{
		return (Role) currentSession().createQuery(
				"From Role where name = :name").setString("name", name).uniqueResult();
	}

}
