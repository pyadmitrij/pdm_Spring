package com.intita.service;

import java.util.List;

import com.intita.domain.Group;

/**
 * @author Dmitriy Pyasetskiy
 */
public interface GroupService 
{
	void addGroup(Group group);
	Group readGroup(Integer groupId);
	List<Group> readAll();
	void deleteGroup(Integer groupId);
}
