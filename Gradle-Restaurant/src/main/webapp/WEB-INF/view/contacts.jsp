<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/contacts.css"/>
    <title>Contacts</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<p class="fig">
    <img width="950" src="resources/img/001.jpg">
</p>

<p id="text">city: Vinnitsa</p>
<p id="text">Phone: (0432) 69-96-88</p>
<p id="text">Phone: (097) 151-57-57</p>
<p id="text">Phone: (063) 503-07-19</p>

<jsp:include flush="true" page="footer.jsp"/>