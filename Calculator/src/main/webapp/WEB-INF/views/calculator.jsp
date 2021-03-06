<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/calc.css"/>
    <title>Calculator</title>
</head>
<body>

<center>
    <h1 id="text">Calculator</h1>
</center>

<form:form method="post" commandName="calcForm">
    <table id='content'>
        <tr>
            <td><label><b>First operand</b></label></td>
            <td><form:input path="a"/></td>
            <td><span class="error"><form:errors path="a"/></span></td>
        </tr>
        <tr>
            <td><label><b>Operatorр</b></label></td>
            <td>
                <form:select path="operator">
                    <form:option value="+" label="+"/>
                    <form:option value="-" label="-"/>
                    <form:option value="*" label="*"/>
                    <form:option value="/" label="/"/>
                    <form:option value="sqrt" label="sqrt"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><label><b>Second operand</b></label></td>
            <td><form:input path="b"/></td>
            <td><span class="error"><form:errors path="b"/></span></td>
        </tr>
        <td><label><b>Result</b></label></td>
        <td><form:input path="result" readonly="true"/></td>
        <td><span class="error"><form:errors path="result"/></span></td>
        </tr>
        <tr>
            <td><input class="button" type="submit" value="Calculate"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
