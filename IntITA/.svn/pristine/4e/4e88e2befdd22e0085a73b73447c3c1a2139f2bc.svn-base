<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include flush="true" page="header.jsp" />
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/resources/css/common.css" />
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/resources/css/user.css" />
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/resources/css/exam.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<br /> <br />
		<h3></h3>
		<table>
			<tr>
				<td><b>id</b></td>
				<td><b>Name</b></td>
				<td><b>Surname</b></td>
				<td><b>Mark</b></td>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td><b>${user.userId}</b></td>
					<td><b>${user.name}</b></td>
					<td><b>${user.surname}</b></td>
					<td><b>${user.userMark}</b></td>
				</tr>
			</c:forEach>
		</table>
	</center>
	<jsp:include flush="footer" page="footer.jsp" />