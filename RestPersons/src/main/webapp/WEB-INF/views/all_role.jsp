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
    <title>All role</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<center>
    <b><font size="+3" color="orange">List of role</font></b><br/>
</center>
<br/>
<table id='content'>
    <tr>
        <td width="50"><b>ID</b></td>
        <td width="100"><b>Name</b></td>
        <td width="100"></td>
    </tr>
    <c:forEach items="${roles}" var="user">
        <tr>
            <td><b>${role.roleId}</b></td>
            <td><b>${role.name}</b></td>
            <td>
                <form action="<c:url value="/update_role/${role.roleId}" />">
                    <input class="button" type="submit" value="Update" />
                </form>
            </td>
            <td>
                <form action="<c:url value="/delete_role/${role.roleId}" />">
                    <input class="button" type="submit" value="Delete" />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include flush="true" page="footer.jsp"/>