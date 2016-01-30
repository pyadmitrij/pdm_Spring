/**
 * 
 */

/**
 * @author Саня
 *
 */
package com.intita.domain;

	import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	@Table(name = "ABSENCE")
	public class Absence {

		@Id
		@Column(name = "ABSENCE_ID")
		@GeneratedValue
		private Integer absence_id;

		@Column(name = "LESSONS_LESSON_ID")
		private Integer lessons_lesson_id;
		
		@Column(name = "USERS_USER_ID")
		private Integer users_user_id;
	
		public Integer getAbsence_id() {
			return absence_id;
		}

		public void setLessons_lesson(Integer lessons_lesson_id) {
			this.lessons_lesson_id = lessons_lesson_id;
		}
		
		public Integer getLessons_lesson_id() {
			return lessons_lesson_id;
		}

		public void setAbsence(Integer absence_id) {
			this.absence_id = absence_id;
		}
		
		public Integer getUsers_user_id() {
			return users_user_id;
		}

		public void setUsers_user_id(Integer users_user_id) {
			this.users_user_id = users_user_id;
		}
}
