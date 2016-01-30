package com.intita.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "folders")
public class Folder {
	@Id
	@GeneratedValue
	@Column(name = "folder_id")
	private Integer id;
	private String name;
	@OneToMany
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "parent_folder_id")
	@Cascade(CascadeType.DETACH)
	private List<Folder> children = new LinkedList<>();
	@OneToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "parent_folder_id")
	Folder parent;

	public Folder() {
	}

	public Folder(String name) {
		this.setName(name);
	}

	/**
	 * @return the parent
	 */
	public Folder getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Folder parent) {
		this.parent = parent;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the children
	 */
	public List<Folder> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<Folder> children) {
		this.children = children;
	}
}
