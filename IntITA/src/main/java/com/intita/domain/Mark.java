/**
 * 
 */

/**
 * @author Саня
 *
 */
package com.intita.domain;

	import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
	@Entity
	@Table(name = "marks")
	public class Mark {

		@Id
		@Column(name = "id")
		@GeneratedValue
		private Integer id;
		
		
		private Integer mark;

		
		private String description;

		@Column(name = "user_id")
		@GeneratedValue
		private Integer userId;
	
		@Column(name = "lesson_id")
		@GeneratedValue
		private Integer lessonId;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getMark() {
			return mark;
		}

		public void setMark(int mark) {
			this.mark = mark;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public Integer getLessonId() {
			return lessonId;
		}

		public void setLessonId(int lessonId) {
			this.lessonId = lessonId;
		}
		
		
}
