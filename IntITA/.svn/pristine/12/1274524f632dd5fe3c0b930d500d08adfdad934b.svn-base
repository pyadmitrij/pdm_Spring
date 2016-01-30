package com.intita.domain;

	import javax.persistence.Column;
	import javax.persistence.Entity;
 	import javax.persistence.GeneratedValue;
    import javax.persistence.Id;
    import javax.persistence.Table;


	@Entity
	@Table(name="classrooms")
	public class Classrooms {
		@Id
		@GeneratedValue
		@Column(name = "classroom_id")
		private Integer classRoomId;

		@Column(name = "name")
		private String name;

		public Integer getId() {
			return classRoomId;
		}

		public void setId(Integer classroomId) {
			this.classRoomId = classroomId;
		}

		public String getName() {
			return name;
		}

		public void setName(String classroom_name) {
			this.name = classroom_name;
		}

}