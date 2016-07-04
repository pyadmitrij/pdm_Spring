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
    <title>Delete user</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<center>
    <b><font size="+3" color="orange">Delete user ${userId}</font></b><br/>
</center>
<br/>

<center><h3>You have deleted a person with userId ${userId}?</h3></center>

<br/>
<table id='content'>
    <tr>

        <td>
            <form:form>
                <input class="button" value="No"/>
                <a href="<c:url value='/all_user'/>" id="all_user"></a>
            </form:form>
        </td>
        <td>
            <form:form action="${pageContext.request.contextPath}/all_user/${user.userId}">
                <input class="button" type="submit" value="Yes"/>
            </form:form>
        </td>
    </tr>
</table>

<center><h3>Time on the server ${serverTime}.</h3></center>

<jsp:include flush="true" page="footer.jsp"/>