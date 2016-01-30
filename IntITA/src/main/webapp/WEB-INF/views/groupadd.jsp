<%-- 
    Document   : groupadd
    Created on : 12.12.2012, 12:35:08
    Author     : Dmitriy Pyasetskiy
--%>

<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/user.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin.css" />
	<title>Admin Page</title>
	<style type="text/css">	span.error {color: red;} </style>
</head>

<jsp:include flush="true" page="header.jsp"/>
<br/>
<jsp:include flush="true" page="adminbutton.jsp"/>
<br/>
<center>
	<b><font size="+3" color="orange">Registration Group</font></b><br/>
</center>
<br/>
<form:form method="post" commandName="group">
<table id='content'>
	<tr>
		<td><form:label path="name"><b>Name</b></form:label></td>
		<td><form:input path="name"/></td>
		<td><form:label path="name"><font color="red"><b>*</b></font></form:label></td>
		<td><span class="error"><form:errors path="name"></form:errors></span></td>
	</tr>
	<tr>
		<td><form:label path="year"><b>Year</b></form:label></td>
		<td><form:input path="year"/></td>
		<td><form:label path="year"><font color="red"><b>* 2012/12/30</b></font></form:label></td>
		<td><span class="error"><form:errors path="year"></form:errors></span></td>
	</tr>
	<tr>
		<td colspan="2"><input class="button" type="submit" value="Add Group"/></td>
	</tr>
</table>
</form:form>
<br/>
<center>
	<b><font size="+3" color="orange">List of Groups</font></b><br/>
</center>
<br/>
<table id='content'>
	<tr>
		<td width="50"><b>ID</b></td>
		<td width="100"><b>Name</b></td>
		<td width="100"><b>Year</b></td>
	</tr>
	<c:forEach items="${groups}" var="group">
		<tr>
			<td><b>${group.groupId}</b></td>
			<td><b>${group.name}</b></td>
			<td><b>${group.year}</b></td>
		</tr>
	</c:forEach>
</table>

<jsp:include flush="footer" page="footer.jsp"/>