/**
 * 
 */
package com.intita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intita.dao.MarkDao;
import com.intita.domain.Mark;
import com.intita.domain.Subject;

/**
 * @author Саня
 *
 */
@Service
public class MarkServiceImpl implements MarkService {
//	private static final GenericDao<Mark, Integer> SubjectDao = null;
	@Autowired
	private MarkDao mark;

	@Autowired
	private com.intita.dao.SubjectDao subjectDao;
	
	public MarkDao getMark() {
		return mark;
	}

	public void setMark(MarkDao mark) {
		this.mark = mark;
	}
	
	@Transactional
	@Override
	public void addMark(Mark mrk) 
	{
		mark.create(mrk);
	}

	@Transactional
	@Override
	public Mark readMark(Integer id) 
	{
		return mark.read(id);
	}

	@Transactional
	@Override
	public java.util.List<Subject> readAllSubjects(){
	
		return subjectDao.readAll();
	}

}
