/**
 * 
 */
package com.intita.domain;
/**
 * @author Barakuda
 *
 */
public class NewLessons {

	private Integer newLessonId = 1;
		
	private String newType = "not";
	
	private Integer data= 1;
	
	private String time= "not";
	
	private String subjectName= "not";
	
	private String classroomName= "not";
	
	private Integer classRoomId=0;
		
	private String groupName= "not";
	
	private String teacherName= "not";
	
	private String teacerGroup="not";
	
	private Integer priority= 0;

	public Integer getNewLessonId() {
		return newLessonId;
	}

	public void setNewLessonId(Integer newLessonId) {
		this.newLessonId = newLessonId;
	}

	public String getNewType() {
		return newType;
	}

	public void setNewType(String newType) {
		this.newType = newType;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getClassroomName() {
		return classroomName;
	}

	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriorety(Integer priority) {
		this.priority = priority;
	}

	public String getTeacerGroup() {
		return teacerGroup;
	}

	public void setTeacerGroup(String teacerGroup) {
		this.teacerGroup = teacerGroup;
	}

	public Integer getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(Integer classRoomId) {
		this.classRoomId = classRoomId;
	}

	
	
}
