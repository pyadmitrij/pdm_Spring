	package com.intita.domain;

	import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
	
	@Entity
	@Table(name ="time")
public class TemporaryTime {
		
		@Id
		@Column(name = "time_id")
		@GeneratedValue
		private Integer timeId;
		
		@Column(name = "time_value")
		private String timeValue;
		
		@Column(name = "priority_time")
		private Integer priorityTime;

		public Integer getTimeId() {
			return timeId;
		}

		public void setTimeId(Integer timeId) {
			this.timeId = timeId;
		}

		public String getTimeValue() {
			return timeValue;
		}

		public void setTimeValue(String timeValue) {
			this.timeValue = timeValue;
		}

		public Integer getPriorityTime() {
			return priorityTime;
		}

		public void setPriorityTime(Integer priorityTime) {
			this.priorityTime = priorityTime;
		}
		
		
}
