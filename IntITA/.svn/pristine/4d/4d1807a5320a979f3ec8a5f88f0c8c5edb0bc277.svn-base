package com.intita.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class File {
	@Id
	@GeneratedValue
	@Column(name = "file_id")
	Integer id;
	String name;
	String path;
	@Column(name = "folder_id")
	Integer folderId;
	
	public File(){	}
	
	public File(String name, String path, Integer folder_id){
		setName(name);
		setPath(path);
		setFolderId(folder_id);
	}
	
	@Override
	public String toString(){
		return getName();
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the folder_id
	 */
	public Integer getFolderid() {
		return folderId;
	}
	/**
	 * @param folder_id the folder_id to set
	 */
	public void setFolderId(Integer folder_id) {
		this.folderId = folder_id;
	}
	
}
