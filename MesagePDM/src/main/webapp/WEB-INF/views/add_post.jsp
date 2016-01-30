<%-- 
    Document   : add_post
    Created on : 21.07.2013
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add_user.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add_post.css"/>
	<title>Add post</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<br/>
<center>
	<b><font size="+3" color="orange">Add post ${user.name}</font></b><br/>
</center>
<br/>

<form:form method="post" modelAttribute="mesage">
<table id='content'>
	<tr>
		<td><form:input type="hidden" value="${user.userId}" path="userId" readonly="true"/></td>
	</tr>
	<tr>
		<td><form:label path="title"><b>Title</b></form:label></td>
		<td><form:input path="title"/></td>
	</tr>
	<tr>
		<td><form:label path="bodyText"><b>Body Text</b></form:label></td>
		<td><form:textarea path="bodyText"/></td>
	</tr>
	<tr>
		<td><form:input type="hidden" value="${serverTime}" path="dataTime" readonly="true"/></td>
	</tr>
	<tr>
		<td colspan="2"><input class="button" type="submit" value="Add Post"/></td>
	</tr>
</table>
</form:form>

<jsp:include flush="footer" page="footer.jsp"/>