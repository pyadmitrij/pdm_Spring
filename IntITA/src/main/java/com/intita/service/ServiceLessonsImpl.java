/**
 * 
 */
package com.intita.service;

/**
 * @author Barakuda
 *
 */
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intita.domain.LessonCalendar;
import com.intita.domain.Lessons;
import com.intita.domain.NewLessons;
import com.intita.domain.Role;
import com.intita.domain.Subject;
import com.intita.domain.User;
import com.intita.dao.GroupDAO;
import com.intita.dao.LessonsDao;
import com.intita.dao.ClassRoomsDao;
import com.intita.dao.SubjectDao;
import com.intita.dao.UserDAO;

@Service
public class ServiceLessonsImpl implements ServiceLessons {
	@Autowired
	LessonsDao lessonsDao;
	@Autowired
	ClassRoomsDao classRoomsDao;
	@Autowired
	UserDAO userDao;
	@Autowired
	SubjectDao subjectDao;
	@Autowired
	GroupDAO groupDao;
	@Autowired
	private UserService userService;

	String typeUser;
	Integer searchId;
	
	String dateStart=null;
	String dateFinish=null;
		
	public LessonCalendar calendarWork(int iYear, int iMonth){
		LessonCalendar lessonCalendar=new LessonCalendar();
		
		 lessonCalendar.setiYear(iYear);
		 lessonCalendar.setiMonth(iMonth);
		 
		 GregorianCalendar cal = new GregorianCalendar (lessonCalendar.getiYear(),lessonCalendar.getiMonth(), 1); 

		lessonCalendar.setDays(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		lessonCalendar.setWeekStartDay(cal.get(Calendar.DAY_OF_WEEK));
		 
		 cal = new GregorianCalendar (lessonCalendar.getiYear(), lessonCalendar.getiMonth(),lessonCalendar.getDays()); 
		lessonCalendar.setiTotalweeks(cal.get(Calendar.WEEK_OF_MONTH));
		
		return lessonCalendar;
		}  

	@Transactional
	public void identificationUser() {
		User user1 = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		for(Role r : user1.getRoles()){
			if(r.getName().equals("student")){
					 this.typeUser="student";
		   			 this.searchId=user1.getGroup().getGroupId();
				}else{		
					 this.typeUser="teacher";
					 this.searchId=user1.getUserId();
				}
		}
	}

	@Transactional
	public String request(int iYear, int iMonth) {
		identificationUser();
		String request;
		String days;
		
		if(calendarWork(iYear,iMonth).getDays()<10){
			days="0"+calendarWork(iYear,iMonth).getDays();
		}else{
			days=""+calendarWork(iYear,iMonth).getDays();
		}
		if(iMonth<10){
		  this.dateStart=""+ iYear+"-0"+ iMonth+"-01";
		  this.dateFinish=""+ iYear+"-0"+ iMonth+"-"+days;}
		else{
			this.dateStart=""+ iYear+"-"+ iMonth+"-01";
			this.dateFinish=""+ iYear+"-"+ iMonth+"-"+days;	
		}
		if (this.typeUser == "teacher") {
			request = " WHERE  user_id = " + this.searchId;
		} else {
			request = " WHERE TIME >= " + this.dateStart + " AND TIME <= "
					+ this.dateFinish + " AND group_id = " + this.searchId;
		}
		return request;
	}

	@Transactional
	public List<Lessons> readWithRequest(String request) {
		List<Lessons> list=Arrays.asList(); 
		if (this.typeUser == "student") {
			 list= lessonsDao.readWithRequest(request);
		} else {
			List<Subject> subjects=subjectDao.readWithRequest(request);
			for(Subject s:subjects){
				int id=s.getSubjectId();
				String request2= " WHERE TIME >= " + this.dateStart + " AND TIME <= "
						+ this.dateFinish + " AND subject_id = "+ id;
				List<Lessons> listForTeach=lessonsDao.readWithRequest(request2);
				for(Lessons y:listForTeach){
				list.add(y);
				}
			}
			return list;
		}
		
		
		
		for(Lessons l:list){
			System.out.println(l.getType());
		}
		return list;
	}

	@Transactional
	public List<NewLessons> responseList(int iYear, int iMonth) {
		String workRequest = request(iYear, iMonth);
		List<NewLessons> newLessons=  fillList(1);  
		List<Lessons> oldLessons = readWithRequest(workRequest);
		for(int i=1; i<=calendarWork(iYear,iMonth+1).getDays();i++){
			int yesDay=0;		
			for (Lessons lessons : oldLessons) {
				if(i==(convertDateDay(lessons.getDatatime()))){
					newLessons.add(generateNewLesson(lessons));
					yesDay++;	}
			}
			if(yesDay==0)
				{newLessons.add(defaultGenerateNewLesson(i));
					}
	  }		
			return newLessons;
	}

	public NewLessons generateNewLesson(Lessons lessons) {
		NewLessons newLessons = new NewLessons();
		newLessons.setNewLessonId(lessons.getLessonId());
		newLessons.setNewType(lessons.getType());
		newLessons.setData(convertDateDay(lessons.getDatatime()));
		newLessons.setTime(convertTime(lessons.getDatatime()));
		newLessons.setSubjectName(subjectDao.read(
					lessons.getSubjectId()).getName());
		newLessons.setClassroomName(classRoomsDao.read(
				lessons.getClassroomId()).getName());
		if (this.typeUser == "teacher"){
		    newLessons.setTeacerGroup(groupDao
				.read(lessons.getGroupId()).getName());
		}else{
			newLessons.setTeacerGroup(userDao.read(
			subjectDao.read(lessons.getSubjectId())
			.getUserId()).getSurname());
		}			
		return newLessons;
	}

	public  NewLessons defaultGenerateNewLesson(int day) {
		NewLessons newLesson = new NewLessons();
		newLesson.setData(day);
			return newLesson;
	}
	
	private List<NewLessons>fillList(int i) {
		List<NewLessons> lessons = new ArrayList<>(); 
		for (int j = 0; j < i; j++) {
			lessons.add(new NewLessons());
		}
		return lessons;
	}
	
	public Integer convertDate(Timestamp datatime) {
		String result = datatime.toString();
		result = result.substring(5, 7);
		Integer iResult = Integer.valueOf(result);
		return iResult;
	}
	
	public Integer convertDateDay(Timestamp datatime) {
		String result = datatime.toString();
		result = result.substring(8, 10);
		Integer iResult = Integer.valueOf(result);
		return iResult;
	}

	public String convertTime(Timestamp datatime) {
		String result = datatime.toString();
		result = result.substring(11, 16);
		return result;
	}

	public LessonsDao getLessonsDao() {
		return lessonsDao;
	}

	public void setLessonsDao(LessonsDao lessonsDao) {
		this.lessonsDao = lessonsDao;
	}

	public ClassRoomsDao getClassRoomsDao() {
		return classRoomsDao;
	}

	public void setClassRoomsDao(ClassRoomsDao classRoomsDao) {
		this.classRoomsDao = classRoomsDao;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	public GroupDAO getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDAO groupDao) {
		this.groupDao = groupDao;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {

		this.searchId = searchId;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateFinish() {
		return dateFinish;
	}

	public void setDateFinish(String dateFinish) {
		this.dateFinish = dateFinish;
	}
	
	

}
