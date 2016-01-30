<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.util.Date"%>
<%@page import="com.intita.domain.Exam"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/resources/css/common.css" />
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/resources/css/user.css" />
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/resources/css/exam.css" />
<title>exam page</title>
</head>

<jsp:include flush="true" page="header.jsp" />

<br />
<center>
	<table>
		<tr>
			<td width="100"><b>Subject</b></td>
			<td width="100"><b>type of lesson</b></td>
			<td width="150"><b>Date/Time</b></td>
			<td width="100"><b>Group</b></td>
			<td width="10"></td>
			<td></td>
		</tr>
		<c:forEach items="${test}" var="offset">
			<form:form action="examStatementList" method="post" modelAttribute="examConnector">
				<tr>
					<td><b>${offset.subjects.name}</b> <form:input type="hidden"path="subjectName" readonly="true"value="${offset.subjects.name}" /></td>
					<td><b>${offset.exams.lessonType}</b> <form:input type="hidden" path="type" readonly="true"value="${offset.exams.lessonType}" /></td>
					<td><b>${offset.exams.time}</b><form:input type="hidden" path="time" readonly="true"value="${offset.exams.time}" /></td>
					<td><b>${offset.groups.name}</b><form:input type="hidden" path="groupName" readonly="true"value="${offset.groups.name}" /></td>
					<td><form:input type="hidden" path="groupId" readonly="true"value="${offset.groups.groupId}" /></td>
					<td><input class="button" type="submit" value="begin test" /></td>
				</tr>
			</form:form>
		</c:forEach>
	</table>
</center>
<jsp:include flush="footer" page="footer.jsp" />