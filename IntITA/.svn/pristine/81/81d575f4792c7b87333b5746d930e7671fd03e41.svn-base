/**
 * 
 */
package com.intita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intita.dao.SubjectDao;
import com.intita.domain.Subject;
import com.intita.domain.User;

/**
 * @author Саня
 * @author Dmitriy Pyasetskiy
 */
@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	private SubjectDao subjectDAO;

	public SubjectDao getSubjectDAO() {
		return subjectDAO;
	}

	public void setSubject(SubjectDao subjectDAO) {
		this.subjectDAO = subjectDAO;
	}
	
	@Transactional
	@Override
	public void addSubject(Subject sub) 
	{
		subjectDAO.create(sub);
	}

	@Transactional
	@Override
	public Subject readSubject(Integer id) 
	{
		return subjectDAO.read(id);
	}
	
	@Transactional
	@Override
	public List<Subject> readAll() 
	{
		return subjectDAO.readAll();
	}

	@Transactional
	@Override
	public List<Subject> findBySubject(User userId) 
	{
		return subjectDAO.findBySubject(userId);
	}

	@Transactional
	@Override
	public void deleteSubject(Integer subjectId) 
	{
		subjectDAO.delete(subjectDAO.read(subjectId));
	}

	@Transactional
	@Override
	public void deleteSubject(Subject subject) 
	{
		subjectDAO.delete(subject);
	}

	@Transactional
	@Override
	public void deleteAllSubject(Integer userId) 
	{
		subjectDAO.deleteAllSubject(userId);
	}
}
