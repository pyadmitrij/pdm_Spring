package com.intita.service;

import java.util.List;

import com.intita.dao.GroupDAO;
import com.intita.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dmitriy Pyasetskiy
 */
@Service
public class GroupServiceImpl implements GroupService
{
	@Autowired
    private GroupDAO groupDAO;

	public GroupDAO getGroupDAO() 
	{
		return groupDAO;
	}

	public void setGroupDAO(GroupDAO groupDAO) 
	{
		this.groupDAO = groupDAO;
	}

	@Transactional
	@Override
	public void addGroup(Group group) 
	{
		groupDAO.create(group);
	}

	@Transactional
	@Override
	public Group readGroup(Integer groupId) 
	{
		return groupDAO.read(groupId);
	}

	@Override
	@Transactional
	public List<Group> readAll() 
	{
		return groupDAO.readAll();
	}

	@Override
	@Transactional
	public void deleteGroup(Integer groupId) 
	{
		groupDAO.delete(groupDAO.read(groupId));
	}
}
