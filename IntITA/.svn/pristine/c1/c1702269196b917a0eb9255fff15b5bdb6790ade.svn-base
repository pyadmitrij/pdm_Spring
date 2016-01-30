package com.intita.service;

import java.sql.Timestamp;
import java.util.List;

import com.intita.domain.Classrooms;
import com.intita.domain.Group;
import com.intita.domain.LessonCalendar;
import com.intita.domain.Lessons;
import com.intita.domain.NewLessons;
import com.intita.domain.Subject;
import com.intita.domain.User;

public interface ServiceSchedule {
	
    public String request(int iYear, int iMonth);
	
	public List<Lessons> readRequest(String request);

	public List<NewLessons> resList(int iYear, int iMonth);
	
	public Integer convertDate(Timestamp datatime);
	
	public String convertTime(Timestamp datatime);
	
	public Integer convertDateDay(Timestamp datatime);
	
	public NewLessons defaultGenerateNewLesson(int day);
	
	public NewLessons generateNewLesson(Lessons lessons);
	
	public LessonCalendar calendarWork(int iYear, int iMonth);
	
	public List<Group> creatlistGroup() ;
	
	public List<Classrooms> creatlistClassrooms() ;
	
	public List<Subject> creatlistSubjects() ;
	
	public List<User> creatlistTeachers() ;
	
	public void addLesson(NewLessons lesson);
	
	public void deleteLesson(Integer id);

}
