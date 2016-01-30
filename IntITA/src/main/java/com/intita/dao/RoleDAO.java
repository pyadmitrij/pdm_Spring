package com.intita.dao;

import com.intita.domain.Role;

public interface RoleDAO extends GenericDao<Role, Integer>
{
	Role find(String name);
}
