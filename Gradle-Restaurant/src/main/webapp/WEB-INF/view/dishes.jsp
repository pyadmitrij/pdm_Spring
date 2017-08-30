<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/menu.css"/>
    <title>Dishes</title>
</head>

<%@include file="header.jsp" %>

<table id="content">
    <tr>
        <td>Name dish</td>
        <td>Weight</td>
        <td>Cost</td>
    </tr>

    <c:forEach items="${dishes}" var="dish">
        <tr>
            <td><a href="/dish${dish.name}">${dish.name}</a></td>
            <td>${dish.weight}</td>
            <td>${dish.cost}</td>
        </tr>
    </c:forEach>

</table>

<%@include file="footer.jsp" %>
