/**
 * @Author Sergey "yakudza" Tatarnikov 
 * @Date 30.02.2013
 * @Please Vinnitsa ITA
 * @Version 1.0
 *  
 */
package com.intita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intita.dao.ExamDao;
import com.intita.domain.Exam;


@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	ExamDao dao;
	
	public ExamDao getDao() {
		return dao;
	}

	public void setDao(ExamDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void addRow(Exam object){
		dao.create(object);
		
	}
	@Transactional
	public Exam readRow(Integer id){
		return dao.read(id);
		
	}
	

	@Override
	@Transactional
	public List<Exam> readAll() {
		return dao.readAll();
	}
	
	@Override
	@Transactional
	public List<Exam> readLessonType(String type) {
		return dao.readLessonType(type);
	}

//	@Override
//	@Transactional
//	public List<Exam> readExamById(Integer id) {
//		return dao.readExamById(id);
//	}
	
}
