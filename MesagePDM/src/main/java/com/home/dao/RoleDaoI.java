package com.home.dao;

import com.home.data.Role;

public interface RoleDaoI extends GenericDaoI<Role, Integer>
{
	Role find(String name);
}
