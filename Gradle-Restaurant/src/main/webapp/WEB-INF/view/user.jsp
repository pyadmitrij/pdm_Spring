<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/user.css"/>
    <title>Employee</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<p id="text">Detailed information about employee</p>

<table id="table">
    <tr>
        <th id="th" width="50">ID</th>
        <th id="th" width="100">Name</th>
        <th id="th" width="100">Surname</th>
        <th id="th" width="100">Birthday</th>
        <th id="th" width="100">Position</th>
        <th id="th" width="100">Phone Number</th>
        <th id="th" width="100">Salary</th>
    </tr>
        <td id="td">${user.id}</td>
        <td id="td">${user.name}</td>
        <td id="td">${user.surname}</td>
        <td id="td">${user.birthday}</td>
        <td id="td">${user.position}</td>
        <td id="td">${user.phone}</td>
        <td id="td">${user.salary}</td>
</table>

<jsp:include flush="true" page="footer.jsp"/>