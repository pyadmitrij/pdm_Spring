package com.intita.dao;

import java.util.List;

import com.intita.domain.Group;
import com.intita.domain.User;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitriy Pyasetskiy
 */

@Repository
public class UserDAOImpl extends GenericDaoImpl<User, Integer> implements UserDAO
{
	
	@Override
	public User findByEmail(String email) 
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM User where email = :email").setString("email", email);
		return ((User) query.uniqueResult());	
	}

	@Override
	public List<User> findByGroupId(Group group) 
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM User where group = :group").setEntity("group", group);
		return  query.list();
	}

	@Override
	public User findByRoleId(Integer roleId) 
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM User where roleId = :roleId").setInteger("roleId", roleId);
		return ((User) query.uniqueResult());
	}

	@Override
	public User readUser(Integer userId) 
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM User where userId = :userId").setInteger("userId", userId);
		return ((User) query.uniqueResult());
	}

	@Override
	public void deleteUser(Integer userId) 
	{
		User user = (User) sessionFactory.getCurrentSession().load(User.class, userId);
		if(null != user)
			sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public void deleteAllUser(Group group) 
	{
		getSessionFactory().getCurrentSession().createQuery(
				"DELETE FROM User where group = :group").setEntity("group", group).executeUpdate();
	}
}
