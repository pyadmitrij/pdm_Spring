package com.intita.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.intita.domain.Group;

/**
 * @author Саня
 * @author Dmitriy Pyasetskiy
 */


@Repository
public class GroupDAOImpl extends GenericDaoImpl<Group, Integer> implements GroupDAO
{	
	@Override
	public Group findById(Integer groupId)
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM groups where groupId = :groupId").setInteger("groupId", groupId);
		return ((Group) query.uniqueResult());
	}

	@Override
	public void deleteGroup(Integer groupId) 
	{
		Group group = (Group) sessionFactory.getCurrentSession().load(Group.class, groupId);
		if(null != group)
			sessionFactory.getCurrentSession().delete(group);
	}
	
}
