<%-- 
    Document   : userpass
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
<b><font size="+3" color="orange">Edit Password</font></b>
</center>
<br/>
<form:form method="post" action="${pageContext.request.contextPath}/userpass" modelAttribute="user">
<table id='content'>
	<tr>
		<td><label><b>Current password</b></label></td>
		<td><input name="oldpassword" type="password" /></td>
		<td><label><font color="red"><b>*</b></font></label></td>
		<td><span class="error"><form:errors path="password"></form:errors></span> </td>
	</tr>
	<tr>
		<td><form:label path="password"><b>New password</b></form:label></td>
		<td><form:password path="password"/></td>
		<td><label ><font color="red"><b>*</b></font></label></td>
		<td><span class="error"><form:errors path="password"></form:errors></span> </td>
	</tr>
	<tr>
		<td colspan="2"><input class="button" type="submit" value="Update" /></td>
	</tr>
</table>
</form:form>

<jsp:include flush="footer" page="footer.jsp"/>