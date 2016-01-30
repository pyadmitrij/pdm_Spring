<%-- 
    Document   : home
    Created on : 18.07.2013, 23:33:26
    Author     : Dmitriy Pyasetskiy
--%>

<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css" />
	<title>Mesage PDM</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<center><h1> Добро пожаловать на портале сообщений!!! </h1></center>

<center><h3> Время на сервере ${serverTime}. </h3></center>

<jsp:include flush="footer" page="footer.jsp"/>