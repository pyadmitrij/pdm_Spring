<%-- 
    Document   : all_post
    Created on : 22.07.2013
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/all_post.css"/>
	<title>All post</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<br/>
<center>
	<b><font size="+3" color="orange">Все сообщения портала</font></b><br/>
</center>
<br/>

<div>
<div style="float:left;">
	<table id='content'>
		<tr>
			<td width="100"><b>User</b></td>
		</tr>	
	<c:forEach items="${users}" var="user">
	<tr>
		<td><b><c:out value="${user.name}"/></b></td> 
	</tr>
	</c:forEach>
	</table>
</div>
<div style="float:left;" >
	<table id='content'>
		<tr>
			<td width="100"><b>Title</b></td>
			<td width="200"><b>Body Text</b></td>
			<td width="150"><b>Data Time</b></td>
		</tr>
	<c:forEach items="${mesages}" var="mesage">
	<tr>
		<td><b><c:out value="${mesage.title}"/></b></td>
		<td><b><c:out value="${mesage.bodyText}"/></b></td>
		<td><b><c:out value="${mesage.dataTime}"/></b></td>
	</tr>
	</c:forEach>
	</table>
</div>
</div>

<jsp:include flush="footer" page="footer.jsp"/>