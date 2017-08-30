<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/users.css"/>
    <title>Employee</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<p id="text">List of users</p>

<table id="table">
    <tr>
        <th id="th" width="50">ID</th>
        <th id="th" width="100">Name</th>
        <th id="th" width="100">Surname</th>
        <th id="th" width="100">Position</th>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td id="td">${user.id}</td>
            <td id="td"><a href="/user/${user.name}">${user.name}</a></td>
            <td id="td">${user.surname}</td>
            <td id="td">${user.position}</td>
        </tr>
    </c:forEach>
</table>

<jsp:include flush="true" page="footer.jsp"/>