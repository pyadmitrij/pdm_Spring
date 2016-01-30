package com.intita.service;

import java.sql.Timestamp;
import java.util.List;

import com.intita.domain.LessonCalendar;
import com.intita.domain.Lessons;
import com.intita.domain.NewLessons;

public interface ServiceLessons {

	public String request(int iYear, int iMonth);
	
	public List<Lessons> readWithRequest(String request);

	public List<NewLessons> responseList(int iYear, int iMonth);
	
	public Integer convertDate(Timestamp datatime);
	
	public String convertTime(Timestamp datatime);
	
	public Integer convertDateDay(Timestamp datatime);
	
	public NewLessons defaultGenerateNewLesson(int day);
	
	public NewLessons generateNewLesson(Lessons lessons);
	
	public LessonCalendar calendarWork(int iYear, int iMonth);
	

}
