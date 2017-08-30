<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css"/>
    <title>Restaurant Hetman</title>
</head>

<jsp:include flush="true" page="header.jsp"/>

<center><h1>Welcome to the restaurant Hetman!!!</h1></center>

<center><h3>It is time: ${currentTime}.</h3></center>

<table id="maket">
    <tr>
        <td><img src="resources/img/Hetman.jpg" width="320" height="224"/></td>
        <td width="640" height="224">
            <p id="text">
                Народна кухня — це така ж культурна спадщина українського народу,
                як мова, література, мистецтво, це неоціненний здобуток,
                яким можна пишатися, який не слід забувати.
            </p>
            <p id="text">
                Але у ресторані «Гетьман» відтворені усі стародавні українські рецепти,
                які вважаються нашою кулінарною спадщиною, та які своїм неперевершеним смаком,
                дадуть Вам поринути у багату та колоритну історію українського народу!
            </p>
        </td>
    </tr>
</table>

<jsp:include flush="true" page="footer.jsp"/>