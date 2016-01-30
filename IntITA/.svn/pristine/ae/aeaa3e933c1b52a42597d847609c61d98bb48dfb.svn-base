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

<center>
	<br />
	<table>
		<tr>
			<td width="100"><b>Subject</b></td>
			<td width="100"><b>Type</b></td>
			<td width="100"><b>Mark</b></td>
			<td width="100"><b>Date</b></td>
		</tr>
		<c:forEach items="${resivers}" var="resiver">
			<tr>
				<td>${resiver.subjectName}</td>
				<td>${resiver.type}</td>
				<td>${resiver.userMark}</td>
				<td>${resiver.time}</td>
			</tr>
		</c:forEach>
	</table>
</center>
<jsp:include flush="footer" page="footer.jsp" />