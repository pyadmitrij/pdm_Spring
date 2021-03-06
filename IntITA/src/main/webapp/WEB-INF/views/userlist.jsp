<%-- 
    Document   : grouplist
    Created on : 19.12.2012, 20:30:55
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
	<link href="<%=request.getContextPath() %>/resources/css/common.css" rel="stylesheet" type="text/css"/>
	<link href="<%=request.getContextPath() %>/resources/css/user.css" rel="stylesheet" type="text/css"/>
	<link href="<%=request.getContextPath() %>/resources/css/admin.css" rel="stylesheet" type="text/css"/>
	<title>Admin Page</title>
</head>

<jsp:include flush="true" page="header.jsp"/>
<br/>
<jsp:include flush="true" page="adminbutton.jsp"/>
<br/>
<center>
	<b><font size="+3" color="orange">List of users group ${group.name}</font></b><br/>
</center>
<br/>
<table id='content'>
	<tr>
		<td width="50"><b>ID</b></td>
		<td width="100"><b>Name</b></td>
		<td width="100"><b>Surname</b></td>
		<td width="100"></td>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td><b>${user.userId}</b></td>
			<td><b>${user.name}</b></td>
			<td><b>${user.surname}</b></td>
			<td>
				<form:form action="${pageContext.request.contextPath}/userlist${user.userId}">
					<input class="button" type="submit" value="Delete"/>
				</form:form>
			</td> 
		</tr>
	</c:forEach>
</table>

<jsp:include flush="footer" page="footer.jsp"/>