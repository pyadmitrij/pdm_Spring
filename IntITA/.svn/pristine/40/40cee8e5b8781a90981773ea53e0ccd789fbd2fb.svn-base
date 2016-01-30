<%-- 
    Document   : user
    Created on : 13.12.2012, 15:40:24
    Author     : Dmitriy Pyasetskiy
--%>

<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/user.css"/>
	<title>User Page</title>
</head>

<jsp:include flush="true" page="header.jsp"/>
<br/>
<center>
	<font size="+3" color="orange"><b>My Information</b></font>
</center>
<br/>
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
		<td><b>Middle Name:</b></td>
		<td><b><c:out value="${user.middleName}"/></b></td>
	</tr>
	<tr>
		<td><b>Birthday:</b></td>
		<td><b><c:out value="${user.birthday}"/></b></td>
	</tr>
	<tr>
		<td><b>Gender:</b></td>
		<td><b><c:out value="${user.sex}"/></b></td>
	</tr>
	<tr>
		<td><b>Agreement:</b></td>
		<td><b><c:out value="${user.agreement}"/></b></td>
	</tr>
	<tr>
		<td><b>Education:</b></td>
		<td><b><c:out value="${user.education}"/></b></td>
	</tr>
	<tr>
		<td><b>Degree:</b></td>
		<td><b><c:out value="${user.degree}"/></b></td>
	</tr>
	<tr>
		<td><b>Work Place:</b></td>
		<td><b><c:out value="${user.workPlace}"/></b></td>
	</tr>
	<tr>
		<td><b>Position:</b></td>
		<td><b><c:out value="${user.position}"/></b></td>
	</tr>
	<tr>
		<td><b>Home phone:</b></td>
		<td><b><c:out value="${user.homePhone}"/></b></td>
	</tr>
	<tr>
		<td><b>Cell phone:</b></td>
		<td><b><c:out value="${user.cellPhone}"/></b></td>
	</tr>
	<tr>
		<td><b>Address</b></td>
		<td><b><c:out value="${user.address}"/></b></td>
	</tr>
	<tr>
		<td><b>Skype</b></td>
		<td><b><c:out value="${user.skype}"/></b></td>
	</tr>
	<tr>
		<td><b>Hobby</b></td>
		<td><b><c:out value="${user.hobby}"/></b></td>
	</tr>
	<tr>
		<td><b>Description</b></td>
		<td><b><c:out value="${user.description}"/></b></td>
	</tr>
	
</table>

<table id='content'>
	<tr>
		<td><form method="get" action="<c:url value="/userupdate" />">
			<input class="button" type="submit" value="Edit Information"/>
		</form></td>
		<td><form method="get" action="<c:url value="/userpass" />">
			<input class="button" type="submit" value="Edit Password"/>
		</form></td>
	</tr>
</table>
<jsp:include flush="footer" page="footer.jsp"/>