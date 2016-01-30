package com.home.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Класс-сущносьть Ролей, для добавления, обновления, удуления.
 * 
 * @author Dmitriy Pyasetskiy
 */

@Entity
@Table(name = "roles")
public class Role 
{
	@Id
	@GeneratedValue
	@Column(name = "role_id")
	private Integer roleId;

	@Column(name = "name")
	private String name;
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
