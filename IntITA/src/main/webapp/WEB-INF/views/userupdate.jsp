<%-- 
    Document   : userupdate
    Created on : 19.12.2012, 18:20:38
    Author     : Dmitriy Pyasetskiy
--%>

<%@page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/user.css"/>
	<title>User Page</title>
	<style type="text/css">	span.error {color: red;} </style>
</head>

<jsp:include flush="true" page="header.jsp"/>
<br/>
<center>
<font size="+3" color="orange"><b>Edit information</b></font>
</center>
<br/>
<form:form method="post" action="${pageContext.request.contextPath}/userupdate" modelAttribute="user">
	<table id='content'>
	<tr>
		<td><b>Name:</b></td>
		<td><b><c:out value="${user.name}"/></b></td>
	</tr>
	<tr>
		<td><b>Surname:</b></td>
		<td><b><c:out value="${user.surname}"/></b></td>
	</tr>
	<tr>
		<td><form:label path="middleName"><b>Midle name</b></form:label></td>
		<td><form:input path="middleName" /></td>
	</tr>
	<tr>
		<td><form:label path="birthday"><b>Birthday</b></form:label></td>
		<td><form:input path="birthday" /><font color="red"><b>* 2012/12/30</b></font></td>
		<td><span class="error"><form:errors path="birthday"></form:errors></span> </td>
	</tr>
		<td><b>Gender</b></td>
		<td>
			<form:radiobutton path="sex" value="M" label="M" /> 
			<form:radiobutton path="sex" value="F" label="F" />
		</td>
	<tr>
		<td><form:label path="education"><b>Education</b></form:label></td>
		<td><form:input path="education" /></td>
	</tr>
	<tr>
		<td><form:label path="degree"><b>Degree</b></form:label></td>
		<td><form:input path="degree" /></td>
	</tr>
	<tr>
		<td><form:label path="workPlace"><b>Work Place</b></form:label></td>
		<td><form:input path="workPlace" /></td>
	</tr>
	<tr>
		<td><form:label path="position"><b>Position</b></form:label></td>
		<td><form:input path="position" /></td>
	</tr>
	<tr>
		<td><form:label path="homePhone"><b>Home Phone</b></form:label></td>
		<td><form:input path="homePhone" /></td>
	</tr>
	<tr>
		<td><form:label path="cellPhone"><b>Cell Phone</b></form:label></td>
		<td><form:input path="cellPhone" /></td>
	</tr>
	<tr>
		<td><form:label path="address"><b>Address</b></form:label></td>
		<td><form:input path="address" /></td>
	</tr>
	<tr>
		<td><form:label path="skype"><b>Skype</b></form:label></td>
		<td><form:input path="skype" /></td>
	</tr>
	<tr>
		<td><form:label path="hobby"><b>Hobby</b></form:label></td>
		<td><form:input path="hobby" /></td>
	</tr>
	<tr>
		<td><form:label path="description"><b>Description</b></form:label></td>
		<td><form:input path="description" /></td>
	</tr>
	<tr>
		<td colspan="2"><input class="button" type="submit" value="Update"/></td>
	</tr>
</table>
</form:form>

<jsp:include flush="footer" page="footer.jsp"/>
