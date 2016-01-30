<%-- 
    Document   : user
    Created on : 21.07.2013, 23:33:26
    Author     : Dmitriy Pyasetskiy
--%>

<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/user.css" />
	<title>User</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

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
		<td><b>Email:</b></td>
		<td><b><c:out value="${user.email}"/></b></td>
	</tr>
</table>

<jsp:include flush="footer" page="footer.jsp"/>