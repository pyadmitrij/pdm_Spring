package com.intita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intita.dao.AbsenceDao;
import com.intita.domain.Absence;


/**
 * @author Саня
 *
 */
@Service
public class AbsenceServiceImpl implements AbsenceService{

	@Autowired
	private AbsenceDao absDAO;

	public AbsenceDao getAbsDAO() {
		return absDAO;
	}

	public void setAbsDAO(AbsenceDao absDAO) {
		this.absDAO = absDAO;
	}

	@Transactional
	@Override
	public void addAbsence (Absence abs) 
	{
		absDAO.create(abs);
	}

	@Transactional
	@Override
	public Absence readAbsence (Integer id) 
	{ 
		return absDAO.read(id);
	}
}
