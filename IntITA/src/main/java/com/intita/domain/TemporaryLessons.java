	package com.intita.domain;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;
	
@Entity
@Table(name ="list_subjects")
public class TemporaryLessons {

		@Id
		@Column(name = "id")
		@GeneratedValue
		private Integer lessonId;
		
		@Column(name = "name")
		private String name;
		
		@Column(name = "teacher_surname")
		private String teacherSurname;
		
		@Column(name = "teacher_id")
		private  Integer teacherId;
		
		@Column(name = "group_id")
		private  Integer groupId;
		
		@Column(name = "lectures_hours")
		private  Integer lecturesHours;

		@Column(name = "practice_hours")
		private  Integer practiceHours;
		
		@Column(name = "seminars_hours")
		private  Integer seminarsHours;
		
		@Column(name = "exams_hour")
		private  Integer examsHours;
		
		@Column(name = "priority")
		private  Integer priority;

		public Integer getLessonId() {
			return lessonId;
		}

		public void setLessonId(Integer lessonId) {
			this.lessonId = lessonId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTeacherSurname() {
			return teacherSurname;
		}

		public void setTeacherSurname(String teacherSurname) {
			this.teacherSurname = teacherSurname;
		}

		public Integer getTeacherId() {
			return teacherId;
		}

		public void setTeacherId(Integer teacherId) {
			this.teacherId = teacherId;
		}

		public Integer getGroupId() {
			return groupId;
		}

		public void setGroupId(Integer groupId) {
			this.groupId = groupId;
		}

		public Integer getLecturesHours() {
			return lecturesHours;
		}

		public void setLecturesHours(Integer lecturesHours) {
			this.lecturesHours = lecturesHours;
		}

		public Integer getPracticeHours() {
			return practiceHours;
		}

		public void setPracticeHours(Integer practiceHours) {
			this.practiceHours = practiceHours;
		}

		public Integer getSeminarsHours() {
			return seminarsHours;
		}

		public void setSeminarsHours(Integer seminarsHours) {
			this.seminarsHours = seminarsHours;
		}

		public Integer getExamsHours() {
			return examsHours;
		}

		public void setExamsHours(Integer examsHours) {
			this.examsHours = examsHours;
		}

		public Integer getPriority() {
			return priority;
		}

		public void setPriority(Integer priority) {
			this.priority = priority;
		}

		

}
