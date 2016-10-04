<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Users</title>
</head>
<body>

<table style="align-items: center">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Position</th>
        <th>Salary</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>${user.position}</td>
        <td>${user.salary}</td>
    </c:forEach>
</table>

</body>
</html>
