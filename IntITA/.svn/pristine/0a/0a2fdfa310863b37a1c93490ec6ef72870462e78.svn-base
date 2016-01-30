<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include flush="true" page="header.jsp" />
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/resources/css/common.css" />
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/resources/css/user.css" />
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/resources/css/exam.css" />
<title>Insert title here</title>
</head>
<center>
	<form:form action="examSave" modelAttribute="examConnector" method="post">
		<table id='content'>
			<tr>
				<td width="50"><b>ID</b></td>
				<td width="100"><b>Name</b></td>
				<td width="100"><b>Surname</b></td>
				<td width="100"><b>Select mark</b></td>
				<td width="100"><b>Previous mark</b></td>
				<td width="100"></td>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><b>${user.userId}</b></td>
					<td><b>${user.name}</b></td>
					<td><b>${user.surname}</b></td>
					<td><form:select path="userMark">
							<form:option value="X" label="X" />
							<form:option value="2" label="2" />
							<form:option value="3" label="3" />
							<form:option value="4" label="4" />
							<form:option value="5" label="5" />
						</form:select></td>
					<td>${user.userMark}</td>
					<td>
						<form:input type="hidden"value="${user.userId}"path="userIdStr" readonly="true" />
					  	<form:input type="hidden"value="${user.name}" path="name" readonly="true" />
						<form:input type="hidden"value="${user.surname}" path="surname"readonly="true" />
						<form:input type="hidden"value="${examConnector.type}" path="type" readonly="true" />
						<form:input type="hidden"value="${examConnector.subjectName}"path="subjectName" readonly="true" />
						<form:input type="hidden"value="${examConnector.time}" path="time" readonly="true" /> 
						<form:input type="hidden"value="${examConnector.groupId}" path="groupId"readonly="true" /> 
						<form:input type="hidden"value="${examConnector.statement}" path="statement"readonly="true" />
						<form:input type="hidden"value="${user.rowId}" path="rowIdStr" readonly="true" />

<!-- 					<input class="button" type="submit" value="Save"/> -->
				  </td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<label>close statement</label>
		<input type="checkbox" value="close" name="status" />
		<br />
		<input class="button" type="submit" value="Save" />

	</form:form>
</center>
<jsp:include flush="footer" page="footer.jsp" />