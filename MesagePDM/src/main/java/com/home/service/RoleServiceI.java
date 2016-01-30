package com.home.service;

import com.home.data.Role;

/**
 * @author Dmitriy Pyasetskiy
 */

public interface RoleServiceI 
{
	Role readRole(Integer roleId);
	Role find(String name);
}
