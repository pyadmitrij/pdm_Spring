package com.intita.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

/**
 * @author Dmitriy Pyasetskiy
 */
@Entity
@Table(name="roles")
public class Role 
{
	@Id
	@GeneratedValue
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users = new HashSet<User>();
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Integer getRoleId() 
	{
		return roleId;
	}
	
	public void setRoleId(Integer roleId) 
	{
		this.roleId = roleId;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
}
