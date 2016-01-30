/**
 * @Author Sergey "yakudza" Tatarnikov 
 * @Date 30.02.2013
 * @Please Vinnitsa ITA
 * @Version 1.0
 *  
 */
package com.intita.service;

import java.util.List;

import org.springframework.stereotype.Service;



import com.intita.domain.Exam;


@Service
public interface ExamService {

	public void addRow(Exam object);
	
	public Exam readRow(Integer id);
	
	public List<Exam> readAll();

	public List<Exam> readLessonType(String type);
	
	//public List<Exam> readExamById(Integer id);
}
