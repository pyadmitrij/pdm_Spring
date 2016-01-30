package com.intita.formModels;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FileCheckModel {
	private List<Integer> ids;

	/**
	 * @return the ids
	 */
	public List<Integer> getIds() {
		return ids;
	}

	/**
	 * @param ids the ids to set
	 */
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
