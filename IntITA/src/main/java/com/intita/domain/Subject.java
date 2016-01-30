package com.intita.domain;

/**
 * @author Саня
 * @author Dmitriy Pyasetskiy
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "subjects")
public class Subject 
{
	@Id
	@Column(name = "subject_id")
	@GeneratedValue
	private Integer subjectId;

	@Size(min=2, message = "Name must have at least 2 charecters!")
	@Column(name = "name")
	private String name;

	@NotNull(message="Enter ID specified teacher")
	@Column(name = "user_id")
	private Integer userId;
	
	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}	
}
