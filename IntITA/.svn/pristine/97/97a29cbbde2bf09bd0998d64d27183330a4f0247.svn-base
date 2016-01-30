<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Create lesson</title>
<script>
function closeWin() {
	window.close();
   }
</script> 	
</head>
<body>
<form:form method="post" modelAttribute="newLessons" action="addLesson">
	<table>
	<tr>
		<td><b>Subject name</b></td>
		<td>
		<form:select path="subjectName">
		<c:forEach items="${subjects}" var="subject">
			<form:option value="${subject.subjectId}" label="${subject.name}"/>
		</c:forEach>
		</form:select>
	   </td>
	</tr>
	<tr>
		<td><b>Teacher</b></td>
		<td>
		<form:select path="teacherName">
		<c:forEach items="${teachers}" var="teacher">
			<form:option value="${teacher.userId}" label="${teacher.surname}"/>
		</c:forEach>
		</form:select>
	   </td>
	</tr>
	<tr>
		<td><form:label path="newType"><b>Type(L,PZ,S,E)</b></form:label></td>
		<td><form:input path="newType" /></td>
	</tr>
	<tr>
		<td><form:label path="time"><b>Date and time format YYYY-MM-DD OO:MM</b></form:label></td>
		<td><form:input path="time" /></td>
	</tr>
	<tr>
		<td><b>Class room</b></td>
		<td>
		<form:select path="classroomName">
		<c:forEach items="${classrooms}" var="classroom">
		  	<form:option value="${classroom.name}" label="${classroom.name}"/>
		</c:forEach>
		</form:select>
	   </td>
	</tr>	
	<tr>
		<td><b>Group</b></td>
		<td>
		<form:select path="groupName">
		<c:forEach items="${groups}" var="group">
			<form:option value="${group.groupId}" label="${group.name}"/>
		</c:forEach>
		</form:select>
	</td>
	</tr>	
	<tr>
		<td colspan="2"><input type="submit" value="Add Lesson" onClick="closeWin()"/></td>
	</tr>
	</table>	
</form:form>
</body>
</html>