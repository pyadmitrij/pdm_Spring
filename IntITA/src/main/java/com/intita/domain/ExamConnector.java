/**
 * @Author Sergey "yakudza" Tatarnikov 
 * @Date 30.02.2013
 * @Please Vinnitsa ITA
 * @Version 1.0
 *  
 */
package com.intita.domain;

import java.sql.Timestamp;
import java.util.List;

public class ExamConnector extends Resiver {
	
	private String userIdStr;
	private String rowIdStr;
	private String statement;
	private String groupName;
	private List<Resiver> resiver;
	
	public List<Resiver> getResiver() {
		return resiver;
	}
	public void setResiver(List<Resiver> resiver) {
		this.resiver = resiver;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getUserIdStr() {
		return userIdStr;
	}
	public void setUserIdStr(String userIdStr) {
		this.userIdStr = userIdStr;
	}
	public String getRowIdStr() {
		return rowIdStr;
	}
	public void setRowIdStr(String rowIdStr) {
		this.rowIdStr = rowIdStr;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
}
