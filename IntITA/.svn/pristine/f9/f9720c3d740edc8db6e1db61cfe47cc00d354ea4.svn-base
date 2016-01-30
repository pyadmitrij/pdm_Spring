	package com.intita.domain;

	import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import java.sql.Timestamp;

	@Entity
	@Table(name = "lessons")
	public class Lessons {
		@Id
		@Column(name = "LESSON_ID")
		@GeneratedValue
		private Integer lessonId;
		
		@Column(name = "TYPE")
		private String type;

		@Column(name = "TIME")
		private  Timestamp datatime;

		@Column(name = "SUBJECT_ID")
		private  Integer subjectId;
		
		@Column(name = "CLASSROOM_ID")
		private Integer classroomId;
		
		@Column(name = "group_id")
		private Integer groupId;
		
		public Integer getLessonId() {
			return lessonId;
		}

		public void setLessonId(Integer lessonId) {
			this.lessonId = lessonId;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Timestamp getDatatime() {
			return datatime;
		}

		public void setDatatime(Timestamp datatime) {
			this.datatime = datatime;
		}

		public Integer getSubjectId() {
			return subjectId;
		}

		public void setSubjectId(Integer subjectId) {
			this.subjectId = subjectId;
		}

		public Integer getClassroomId() {
			return classroomId;
		}

		public void setClassroomId(Integer classroomId) {
			this.classroomId = classroomId;
		}

		public Integer getGroupId() {
			return groupId;
		}

		public void setGroupId(Integer groupId) {
			this.groupId = groupId;
		}
}
