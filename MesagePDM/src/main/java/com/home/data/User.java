package com.home.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Класс-сущность Пользователей, для добавления, обновления, удуления.
 * @author Dmitriy Pyasetskiy
 */

@Entity
@Table(name = "users")
public class User 
{
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "role_id")
	private Integer roleId;

	@Email
	@Column(name = "email")
	private String email;
	
	@Size(min=3, max=10)
	@Column(name = "password")
	private String password;
	
	@Size(min=2, max=16)
	@Column(name = "name")
	private String name;
	
	@Size(min=3, max=16)
	@Column(name = "surname")
	private String surname;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
