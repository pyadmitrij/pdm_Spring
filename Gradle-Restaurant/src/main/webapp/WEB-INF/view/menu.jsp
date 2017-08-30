<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/button.css"/>
    <title>Menu</title>
</head>

<jsp:include flush="true" page="header.jsp"/>
<br/>
<%@include file="button.jsp" %>

<p id="text">List of dishes</p>

<table id='table'>
    <tr>
        <td id="td" width="50"><b>ID</b></td>
        <td id="td" width="100"><b>Name</b></td>
        <td id="td" width="100"><b>Weight</b></td>
        <td id="td" width="100"><b>Price</b></td>
    </tr>
    <c:forEach items="${dishes}" var="dish">
        <tr>
            <td id="td"><b>${dish}</b></td>
            <td id="td"><b>${dish}</b></td>
            <td id="td"><b>${dish}</b></td>
            <td id="td"><b>${dish}</b></td>
        </tr>
    </c:forEach>
</table>

<jsp:include flush="true" page="footer.jsp"/>
