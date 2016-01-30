package com.intita.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;

/**
 * @author Dmitriy Pyasetskiy
 */
@Entity
@Table(name = "users")
//@OnDelete(action=OnDeleteAction.CASCADE)
public class User 
{
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Integer userId;
	
	@ManyToOne(targetEntity = Group.class)
	@JoinColumn(name = "group_id")
	private Group group;
	
	@Email()
	@Column(name = "email")
	private String email;
	
	@Size(min=3, max=10)
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	@Size(min=2, max=16)
	private String name;
	
	@Size(min=3, max=16)
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "birthday")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name = "sex")
	private Character sex;
	
	@Size(min=3, max=10)
	@Column(name = "agreement")
	private String agreement;
	
	@Column(name = "education")
	private String education;
	
	@Column(name = "degree")
	private String degree;
	
	@Column(name = "work_place")
	private String workPlace;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "home_phone")
	private String homePhone;
	
	@Column(name = "cell_phone")
	private String cellPhone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "skype")
	private String skype;
	
	@Column(name = "hobby")
	private String hobby;
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany(cascade = {CascadeType.DETACH})
	@JoinTable(name="users_roles", 
		joinColumns={@JoinColumn(name="user_id")},
		inverseJoinColumns={@JoinColumn(name="role_id")})
	@Fetch(value=FetchMode.JOIN)
	private Set<Role> roles = new HashSet<Role>();

	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	public String getAgreement() {
		return agreement;
	}
	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSkype() {
		return skype;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
