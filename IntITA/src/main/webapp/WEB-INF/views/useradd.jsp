<%-- 
    Document   : useradd
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/user.js"></script>
	<title>Admin Page</title>
	<style type="text/css">	span.error 	{color: red;} </style>
</head>

<jsp:include flush="true" page="header.jsp"/>
<br/>
<jsp:include flush="true" page="adminbutton.jsp"/>
<br/>
<center>
	<b><font size="+3" color="orange">Registration User</font></b><br/>
</center>
<br/>
<form:form method="post" modelAttribute="user">
<table id='content'>
	<tr>
		<td><form:label path="email"><b>Email</b></form:label></td>
		<td><form:input path="email"/></td>
		<td><form:label path="email"><font color="red"><b>*</b></font></form:label></td>
		<td><form:errors path="email" cssClass="error"></form:errors> </td>
	</tr>
	<tr>
		<td><form:label path="password"><b>Password</b></form:label></td>
		<td><form:input path="password"/></td>
		<td><form:label path="password"><font color="red"><b>*</b></font></form:label></td>
		<td><span class="error"><form:errors path="password"></form:errors></span></td>
	</tr>
	<tr>
		<td><form:label path="name"><b>Name</b></form:label></td>
		<td><form:input path="name"/></td>
		<td><form:label path="name"><font color="red"><b>*</b></font></form:label></td>
		<td><span class="error"><form:errors path="name"></form:errors></span></td>
	</tr>
	<tr>
		<td><form:label path="surname"><b>Surname</b></form:label></td>
		<td><form:input path="surname"/></td>
		<td><form:label path="surname"><font color="red"><b>*</b></font></form:label></td>
		<td><span class="error"><form:errors path="surname"></form:errors></span></td>
	</tr>
	<tr>
		<td><form:label path="agreement"><b>Agreement</b></form:label></td>
		<td><form:input path="agreement"/></td>
		<td><form:label path="agreement"><font color="red"><b>*</b></font></form:label></td>
		<td><span class="error"><form:errors path="agreement"></form:errors></span></td>
	</tr>
	<tr>
		<td><b>ROLE</b></td>
		<td>
		<c:forEach items="${roles}" var="role">
			<input type="checkbox" id="${role.name}"  value="${role.roleId}" name="roleId" onclick="ChangeAbz1(${role.name})"/>${role.name}
<%-- 			<form:checkbox id="${role.name}" path="roles" value="${role.roleId}" label="${role.name} " onclick="ChangeAbz1(${role.name})"/> --%>
		</c:forEach>
		</td>
		<td><font color="red"><b>*</b></font></td>
	</tr>
	
	<tr>
		<td><span style="display:none" id="p1"><b>GROUP</b></span></td>
<!-- 		<td><b>GROUP</b></td> -->
		<td>
		<span style="display:none" id="p2">
<%-- 		<form:select path="groupId"> --%>
		<select name="groupId">
		<c:forEach items="${groups}" var="group">
			<option value="${group.groupId}">${group.name}</option>
		</c:forEach>
		</select>
<%-- 		</form:select> --%>
		</span>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input class="button" type="submit" value="Add User"/></td>
	</tr>
</table>
</form:form>
<br/>
<center>
	<b><font size="+3" color="orange">Added User</font></b><br/>
</center>
<br/>
<table id='content'>
	<tr>
		<td width="50"><b>ID</b></td>
		<td width="100"><b>Name</b></td>
		<td width="100"><b>Surname</b></td>
		<td width="100"><b>Email</b></td>
	</tr>
<%-- 		<c:forEach items="${users}" var="user"> --%>
	<tr>
		<td><b><c:out value="${addeduser.userId}"/></b></td>
		<td><b><c:out value="${addeduser.name}"/></b></td>
		<td><b><c:out value="${addeduser.surname}"/></b></td>
		<td><b><c:out value="${addeduser.email}"/></b></td>
	</tr>
<%-- 		</c:forEach> --%>
</table>

<jsp:include flush="footer" page="footer.jsp"/>