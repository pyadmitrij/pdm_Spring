package com.home.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.home.data.User;

/**
 * UserDAO implements interaction between User entity and database 
 * 
 * @author Dmitriy Pyasetskiy
 */

@Repository
public class UserDAO extends GenericDAO<User, Integer> implements UserDaoI 
{
	/**
	 * ����� ������������ � ����, �� ��� ����� �����
	 * @param email ����� ������������
	 * @return instance of User from database.
	 */
	@Override
	public User findByEmail(String email) 
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM User where email = :email").setString("email", email);
		return ((User) query.uniqueResult());
	}
	
	/**
	 * ������� ������������ � ����
	 * @param userId �� ������������
	 */
	@Override
	public void deleteUser(Integer userId) 
	{
		User user = (User) sessionFactory.getCurrentSession().load(User.class, userId);
		if(user != null)
			sessionFactory.getCurrentSession().delete(user);
	}

	/**
	 * ���� ����������� � ����, �� ��� �� ����
	 * @param roleId �� ���� ������������ 
	 * @return instance of User from database.
	 */
	@Override
	public User findByRoleId(Integer roleId) 
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM User where roleId = :roleId").setInteger("roleId", roleId);
		return ((User) query.uniqueResult());
	}
}
