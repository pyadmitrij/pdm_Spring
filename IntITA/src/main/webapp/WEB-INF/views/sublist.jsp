<%-- 
    Document   : sublist
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
	<b><font size="+3" color="orange">List of subjects teacher ${user.surname}</font></b><br/>
</center>
<br/>
<table id='content'>
<tr>
	<td width="50"><b>ID</b></td>
	<td width="100"><b>Name</b></td>
	<td width="100"></td>
</tr>
<c:forEach items="${subjects}" var="subject">
	<tr>
		<td><b>${subject.subjectId}</b></td>
		<td><b>${subject.name}</b></td>
		<td>
		<form method="get" action="${pageContext.request.contextPath}/sublist${subject.subjectId}">
			<input class="button" type="submit" value="Delete"/>
		</form>
		</td>
	</tr>
</c:forEach>
</table>
<br/>
<center>
	<b><font size="+3" color="orange">Add Subject</font></b><br/>
</center>
<br/>
<form:form method="post" modelAttribute="subject">
<table id='content'>
	<tr>
		<td><form:label path="name"><b>Name</b></form:label></td>
		<td><form:input path="name"/></td>
		<td><form:label path="name">*</form:label></td>
		<td><form:errors path="name" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td><form:label path="userId"><b>ID ${user.userId}</b></form:label></td>
		<td><form:input type="hidden" value="${user.userId}" path="userId" readonly="true"/>
<%-- 		<td><form:input path="userId"/></td> --%>
<%-- 		<td><form:label path="userId">*</form:label></td> --%>
<%-- 		<td><form:errors path="userId" cssClass="error"></form:errors></td> --%>
	</tr>	
	<tr>
		<td colspan="2"><input class="button" type="submit" value="Add Subject"/></td>
	</tr>
</table>
</form:form>

<jsp:include flush="footer" page="footer.jsp"/>