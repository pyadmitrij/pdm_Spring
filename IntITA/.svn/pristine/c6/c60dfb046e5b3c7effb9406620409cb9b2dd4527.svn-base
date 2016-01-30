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

import com.intita.domain.Classrooms;
import com.intita.domain.Group;
import com.intita.domain.LessonCalendar;
import com.intita.domain.Lessons;
import com.intita.domain.NewLessons;
import com.intita.domain.Subject;
import com.intita.domain.User;
import com.intita.dao.GroupDAO;
import com.intita.dao.LessonsDao;
import com.intita.dao.ClassRoomsDao;
import com.intita.dao.SubjectDao;
import com.intita.dao.UserDAO;

@Service
public class ServiceScheduleImpl implements  ServiceSchedule {
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
	UserService userService;
	
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
	public List<Classrooms> creatlistClassrooms() 
	{		
		return classRoomsDao.readAll();
	}
	
	@Transactional
	@Override
	public List<Subject> creatlistSubjects() 
	{		
		return subjectDao.readAll();
	}
	
	@Transactional
	@Override
	public List<User> creatlistTeachers() 
	{		
		return  userService.findByUserRole(2);
	}
	
	@Transactional
	@Override
	public void addLesson(NewLessons newLesson){
		Lessons lesson= new Lessons();
		lesson.setType(newLesson.getNewType());
		lesson.setSubjectId(newLesson.getNewLessonId());
		lesson.setGroupId(Integer.parseInt(newLesson.getGroupName()));
		lesson.setClassroomId(newLesson.getClassRoomId());
		int id=1;
		String name=newLesson.getClassroomName();
		List<Classrooms> classRooms=creatlistClassrooms();
		for(Classrooms c:classRooms){
			if(c.getName()==name){
			id=c.getId();
			}
		}		
		lesson.setClassroomId(id);
		String dateTime = ""+newLesson.getTime()+":00.000000000";
		java.sql.Timestamp time=java.sql.Timestamp.valueOf(dateTime);
		lesson.setDatatime(time);
		lessonsDao.create(lesson);
	}
	
	@Transactional
	@Override
	public void deleteLesson(Integer id){
		Lessons les=lessonsDao.read(id);
		lessonsDao.delete(les);
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


}
