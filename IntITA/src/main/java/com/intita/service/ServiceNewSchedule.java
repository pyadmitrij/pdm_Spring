/**
 * 
 */
package com.intita.service;

import java.sql.Timestamp;
import java.util.List;

import com.intita.domain.Classrooms;
import com.intita.domain.Group;
import com.intita.domain.LessonCalendar;
import com.intita.domain.Lessons;
import com.intita.domain.NewLessons;
import com.intita.domain.TemporaryLessons;
import com.intita.domain.TemporaryTime;
import com.intita.domain.User;

/**
 * @author Barakuda
 *
 */
public interface ServiceNewSchedule {
			
		public Integer convertDate(Timestamp datatime);
		
		public String convertTime(Timestamp datatime);
		
		public Integer convertDateDay(Timestamp datatime);
		
		public NewLessons defaultGenerateNewLesson(int day);
		
		public NewLessons generateNewLesson(Lessons lessons);
		
		public LessonCalendar calendarWork(int iYear, int iMonth);
		
		public List<Group> creatlistGroup();
		
		public List<User> creatlistTeachers(); 
		
		public List<TemporaryTime> creatlistTime() ;
		
		public List<TemporaryLessons> creatlistTemporaryLessons() ;
		
		public List<Classrooms> creatlistClassRooms() ;
		
		public void deleteTime(Integer id);
		
		public void addTime(TemporaryTime  temporaryTime);
		
		public void deleteTemporeryLessons(Integer id);
		
		public void addTemporeryLesson(TemporaryLessons lesson);
		
		public void deleteClassRoom(Integer id);
		
		public void addClassRoom(Classrooms classroom);
		
		public int[][] prioretyMatrix(int iYear, int iMonth);
		
		public void saveNewSchedule(int iYear, int iMonth);

}
