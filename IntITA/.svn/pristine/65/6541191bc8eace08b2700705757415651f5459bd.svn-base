/**
 * 
 */
package com.intita.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.intita.domain.Subject;
import com.intita.domain.User;

/**
 * @author Саня
 * @author Dmitriy Pyasetskiy
 */
@Repository
public class SubjectDaoImpl extends GenericDaoImpl<Subject, Integer> implements SubjectDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> getSubjects(int userId) 
	{
		return currentSession().createQuery(
				"FROM Subject where userId = :userId").setInteger("userId", userId).list();
	}

	@Override
	public List<Subject> findBySubject(User userId) 
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM Subject where userId = :userId").setEntity("userId", userId);
		return  query.list();
	}

	@Override
	public void deleteSubject(Integer subjectId) 
	{
		Subject subject = (Subject) sessionFactory.getCurrentSession().load(Subject.class, subjectId);
		if(null != subject)
			sessionFactory.getCurrentSession().delete(subject);
	}

	@Override
	public void deleteAllSubject(Integer userId) 
	{
		getSessionFactory().getCurrentSession().createQuery(
				"DELETE FROM Subject where userId = :userId").setInteger("userId", userId).executeUpdate();
	}

}
