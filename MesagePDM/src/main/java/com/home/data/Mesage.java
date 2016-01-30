package com.home.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * Класс-сущность Сообщений, для добавления, обновления, удуления.
 * 
 * @author Dmitriy Pyasetskiy
 */

@Entity
@Table(name = "mesages")
public class Mesage 
{
	@Id
	@GeneratedValue
	@Column(name = "mesage_id")
	private Integer mesageId;
	
	@Column(name = "user_id")
	@Cascade(CascadeType.DETACH)
	private Integer userId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "body_text")
	private String bodyText;
	
	@Column(name = "data_time")
	private String dataTime;

	public Integer getMesageId() {
		return mesageId;
	}

	public void setMesageId(Integer mesageId) {
		this.mesageId = mesageId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public String getDataTime() {
		return dataTime;
	}

	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
}
