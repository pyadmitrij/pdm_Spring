<%-- 
    Document   : home
    Created on : 13.12.2012, 15:40:24
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css" />
	<title>Home ITA</title>
</head>
<jsp:include flush="true" page="header.jsp"/>
<table id='content'>
	<tr>
		<td><font size="+3" color="green">Абітурієнтам</font></td>
	</tr>
	<tr>
	<td><font size="+2">
		Бажаєте стати висококласним програмістом і гарантовано отримати престижну, 
		високооплачувану роботу? Для цього Вам потрібні гарні теоретичні знання, 
		практичний досвід розробки сучасних ІТ-проектів, відмінне розуміння 
		сучасних ІТ-технологій. Все це можна отримати у Вінницькій ІТ-Академії.
	</font></td>
	</tr>
	<tr>
		<td><font size="+3" color="green">Компаніям</font></td>
	</tr>
	<tr>
	<td><font size="+2">
		Як вирішити гостру проблему нестачі кваліфікованих ІТ-спеціалістів, постійної плинності 
		кадрів, підвищення кваліфікації власного ІТ-персоналу? Тільки 10-15% випускників ІТ-
		спеціальностей отримують роботу в ІТ-компаніях і так чи інакше відповідають їх вимогам. 
		Спільно з Вінницькою ІТ-Академією Ви зможете вирішити ці проблеми.
	</font></td>
	</tr>
</table>
<jsp:include flush="footer" page="footer.jsp"/>