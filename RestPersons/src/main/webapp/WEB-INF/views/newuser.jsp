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
    <title>Add user</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<br/>
<center>
    <b><font size="+3" color="orange">Registration User</font></b><br/>
</center>
<br/>

<form:form method="post" modelAttribute="user">
    <form:input type="hidden" path="id" id="id"/>
<table id='content'>
    <tr>
        <td><form:label path="userName"><b>UserName</b></form:label></td>
        <td><form:input path="userName"/></td>
        <td><form:label path="userName"><font color="red"><b>*</b></font></form:label></td>
        <td><form:errors path="userName" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="password"><b>Password</b></form:label></td>
        <td><form:input path="password"/></td>
        <td><form:label path="password"><font color="red"><b>*</b></font></form:label></td>
        <td><span class="error"><form:errors path="password"></form:errors></span></td>
    </tr>
    <tr>
        <td><b>ROLE</b></td>
        <td>
            <c:forEach items="${roles}" var="role">
                <input type="checkbox" id="${role.name}" value="${role.roleId}" name="roleId"
                       onclick="ChangeAbz1(${role.name})"/>${role.name}
            </c:forEach>
        </td>
        <td><font color="red"><b>*</b></font></td>
    </tr>
    <tr>
        <td colspan="2"><input class="button" type="submit" value="Add User"/></td>
    </tr>
</table>
</form:form>

<br/>
<center>
    <b><font size="+3" color="orange">Added User</font></b><br/>
</center>
<br/>
<table id='content'>
    <tr>
        <td width="50"><b>ID</b></td>
        <td width="100"><b>Name</b></td>
    </tr>
    <tr>
        <td><b><c:out value="${addeduser.userId}"/></b></td>
        <td><b><c:out value="${addeduser.userName}"/></b></td>
    </tr>
</table>

<jsp:include flush="true" page="footer.jsp"/>
