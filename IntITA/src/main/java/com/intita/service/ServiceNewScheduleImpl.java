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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import scheduleAlgorithmCPU.HungarianAlgorithm;

import com.intita.domain.Classrooms;
import com.intita.domain.Group;
import com.intita.domain.LessonCalendar;
import com.intita.domain.Lessons;
import com.intita.domain.NewLessons;
import com.intita.domain.Subject;
import com.intita.domain.TemporaryLessons;
import com.intita.domain.TemporaryTime;
import com.intita.domain.User;
import com.intita.dao.GroupDAO;
import com.intita.dao.LessonsDao;
import com.intita.dao.ClassRoomsDao;
import com.intita.dao.SubjectDao;
import com.intita.dao.TemporaryLessonsDao;
import com.intita.dao.TemporaryTimeDao;
import com.intita.dao.UserDAO;

@Service
public class ServiceNewScheduleImpl implements  ServiceNewSchedule {
    
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
	TemporaryTimeDao temporaryTimeDao;
	@Autowired
	TemporaryLessonsDao temporaryLessonsDao;
	
	HungarianAlgorithm hA;

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
	public String request(int iYear, int iMonth) {
		String request;
		String days;
		String dateStart=null;
		String dateFinish=null;
		if(calendarWork(iYear,iMonth).getDays()<10){
			days="0"+calendarWork(iYear,iMonth).getDays();
		}else{
			days=""+calendarWork(iYear,iMonth).getDays();
		}
		if(iMonth<10){
		  dateStart=""+ iYear+"-0"+ iMonth+"-01";
		  dateFinish=""+ iYear+"-0"+ iMonth+"-"+days;}
		else{
			 dateStart=""+ iYear+"-"+ iMonth+"-01";
			   dateFinish=""+ iYear+"-"+ iMonth+"-"+days;	
		}
		request = " WHERE TIME >= " + dateStart + " AND TIME <= "
					+ dateFinish;
		return request;
	}

	@Transactional
	public List<Lessons> readRequest(String request) {
		return (List<Lessons>) lessonsDao.readWithRequest(request);
	}

	@Transactional
	public List<NewLessons> resList(int iYear, int iMonth) {
		String workRequest = request(iYear, iMonth);
		List<NewLessons> newLessons=  fillList(1);  
		List<Lessons> oldLessons = readRequest(workRequest);
		for(int i=1; i<=calendarWork(iYear,iMonth-1).getDays();i++){
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
		newLessons.setGroupName(groupDao
				.read(lessons.getGroupId()).getName());
		newLessons.setTeacherName(userDao.read(
				subjectDao.read(lessons.getSubjectId())
				.getUserId()).getSurname());			
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

	@Transactional
	@Override
	public List<Group> creatlistGroup() 
	{		
		return groupDao.readAll();
	}
	
	@Transactional
	@Override
	public List<TemporaryTime> creatlistTime() 
	{		
		return temporaryTimeDao.readAll();
	}
	
	@Transactional
	@Override
	public List<TemporaryLessons> creatlistTemporaryLessons() 
	{		
		return temporaryLessonsDao.readAll();
	}
	
	@Transactional
	@Override
	public List<Classrooms> creatlistClassRooms() 
	{		
		return classRoomsDao.readAll();
	}
	
	@Transactional
	@Override
	public List<User> creatlistTeachers() 
	{		
		return userDao.readWithRequest("WHERE group_id ="+1);
	}
	
	public void addTime(TemporaryTime  temporaryTime){
        temporaryTimeDao.create(temporaryTime);
	}
	
	public void deleteTime(Integer id){
        TemporaryTime t=temporaryTimeDao.read(id);
		   temporaryTimeDao.delete(t);
	}
	
	public void addTemporeryLesson(TemporaryLessons lesson){
		temporaryLessonsDao.create(lesson);
	}
	
	public void deleteTemporeryLessons(Integer id){
		TemporaryLessons tl=temporaryLessonsDao.read(id);
		temporaryLessonsDao.delete(tl);
	}
	
	public void addClassRoom(Classrooms classroom){
		
		classRoomsDao.create(classroom);
	}
	
	public void deleteClassRoom(Integer id){
		Classrooms c=classRoomsDao.read(id);
		classRoomsDao.delete(c);
	}
	
	public int[][] prioretyMatrix(int iYear, int iMonth){
		  int[][] matrix = {{0,0,0,0,0,},{0,1,7,1,3}, {0,1,6,4,6}, {0,17,1,5,1}, {0,1,6,10,4}};
		  // a.algorithmCPU( matrix);
		return matrix;
	}
	
	public void saveNewSchedule(int iYear, int iMonth){
		System.out.println("works");
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

	public TemporaryTimeDao getTemporaryTimeDao() {
		return temporaryTimeDao;
	}

	public void setTemporaryTimeDao(TemporaryTimeDao temporaryTimeDao) {
		this.temporaryTimeDao = temporaryTimeDao;
	}

	public TemporaryLessonsDao getTemporaryLessonsDao() {
		return temporaryLessonsDao;
	}

	public void setTemporaryLessonsDao(TemporaryLessonsDao temporaryLessonsDao) {
		this.temporaryLessonsDao = temporaryLessonsDao;
	}

	public HungarianAlgorithm gethA() {
		return hA;
	}

	public void sethA(HungarianAlgorithm hA) {
		this.hA = hA;
	}

		
}
