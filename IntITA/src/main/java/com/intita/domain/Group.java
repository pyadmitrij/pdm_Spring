package com.intita.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * @author Alex
 * @author Dmitriy Pyasetskiy
 */
@Entity
@Table(name="groups")
public class Group 
{
  @Id
  @GeneratedValue
  @Column(name = "group_id")
  private Integer groupId;
  
  @Size(min=2, message = "Name must have at least 2 characters!")
  @Column(name = "name")
  private String name;
  
  @Column(name = "year")
  @Temporal(TemporalType.DATE)
  private Date year;

  public Integer getGroupId() {
    return groupId;
  }

  public String getName() {
    return name;
  }

  public Date getYear() {
    return year;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setYear(Date year) {
    this.year = year;
  }
}