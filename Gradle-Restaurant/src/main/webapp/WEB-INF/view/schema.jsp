<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/schema.css"/>
    <title>Schema</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<p class="fig">
    <img src="resources/img/schema.png">
</p>
<jsp:include flush="true" page="footer.jsp"/>