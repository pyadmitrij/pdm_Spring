<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add_user.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin.css"/>
    <title>Update role</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<br/>
<center>
    <font size="+3" color="orange"><b>Edit role</b></font>
</center>
<br/>

<form:form method="post" action="${pageContext.request.contextPath}/update_role" modelAttribute="role">
<table id='content'>
    <tr>
        <td><b>RoleName:</b></td>
        <td><b><c:out value="${role.name}"/></b></td>
    </tr>
        <td colspan="2"><input class="button" type="submit" value="Update"/></td>
    </tr>
</table>
</form:form>


<center><h3>Time on the server ${serverTime}.</h3></center>

<jsp:include flush="true" page="footer.jsp"/>