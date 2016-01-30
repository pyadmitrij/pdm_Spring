<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  language="java" import="java.util.*,java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.intita.domain.NewLessons"%>
<%@ page import="com.intita.domain.LessonCalendar"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	LessonCalendar newCalendar=(LessonCalendar) request.getAttribute("calendar");
 %>
<html>
<head>
<title>newschedule</title>
<script>
function openWin1() {
    msgWindow= open("newsubject","newsubject",
     "width=350,height=550,status=no,toolbar=no,menubar=no,scrollbars=no")
   }
</script> 
<script>
function openWin2() {
    msgWindow= open("newtime","newtime",
     "width=350,height=550,status=no,toolbar=no,menubar=no,scrollbars=no")
   }
</script> 
<script>
function openWin3() {
    msgWindow= open("newclassroom","newclassroom",
     "width=350,height=550,status=no,toolbar=no,menubar=no,scrollbars=no")
   }
</script> 
<script>
function closeWin() {
	window.close();
   }
</script> 
<meta http-equiv="Content-Style-Type" content="text/css"/>
</head>
<body>
<form:form method="post" modelAttribute="newLessons" action="addLesson">
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
	  	   <td colspan="2"> 
		     <input type="button" value="Create Subject" onClick="openWin1()"/>
		   </td>
		   <td width="2%"></td>
<%-- 		   <td colspan="2"><form method="post" action="<c:url value="/deletesubject" />"> --%>
<!-- 			 <input type="submit" value="Delete"/>  -->
<!-- 		   </td> -->
	</tr>
	<tr>
	  <td><table id="mp" align="center" border="3" cellpadding="3" cellspacing="0" width="100%" >
	      <tbody>
	        <tr>
	          <th colspan="2" id="p1" >Name</th>
	          <th id="p1">Teacher</th>
	          <th id="p1">Group</th>
	          <th id="p1">lectures hours</th>
	          <th id="p1">practice hours</th>
	          <th id="p1">seminar hours</th>
	          <th id="p1"> exams hours</th>
	        </tr>
	      <c:forEach items="${listTL}" var="temporaryLessons">
				<tr>
<%-- 					<td><form:checkbox path="id" value="${temporaryLessons.lessonId}"/></td>  --%>
					<td>${temporaryLessons.name}</td> 
					<td>${temporaryLessons.teacherSurname}</td>
					<td>${temporaryLessons.groupId}</td> 
					<td>${temporaryLessons.lecturesHours}</td>
					<td>${temporaryLessons.practiceHours}</td>
					<td>${temporaryLessons.seminarsHours}</td>
					<td>${temporaryLessons.examsHours}</td>
				</tr>
		  </c:forEach>
		  </tbody>
	      </table>
	   </td>
	</tr>	  
	<tr>
	  	  <td colspan="2"> 
		     <input type="button" value="Create Time" onClick="openWin2()">
		  </td>
	</tr>
    <tr>
      <td><table id="mp" align="center" border="3" cellpadding="3" cellspacing="0" width="100%" >
      <tbody>
	      <tr>
	          <th id="p1"></th>
	          <th id="p1">Time</th>
	      </tr>
	    <c:forEach items="${listTT}" var="temporaryTime">
			<tr>
<%-- 	 		<td><form:checkbox path="id" value="${temporaryTime.timeId}"/></td>  --%>
			<td>${temporaryTime.timeValue}</td> 
			</tr>
	    </c:forEach>
	  </tbody>
      </table></td>
   </tr>
	  
   <tr>
	  <td colspan="2"> 
	   <input type="button" value="Create Classroom"onClick="openWin3()">
	  </td>
      <td width="2%"></td> 
<%-- 	   < td colspan="2"><form method="post" action="<c:url value="/delete" />"> --%>
<!-- 				<input type="submit" value="Delete"/>  --> 
<!-- 	   </td>  -->
    </tr>
    <tr> 
	    <td><table id="mp" align="center" border="3" cellpadding="3" cellspacing="0" width="100%" > 
		      <tbody> 
		         <tr> 
			          <th id="p1"></th> 
			          <th id="p1">Classroom</th> 
		         </tr> 
		      <c:forEach items="${listC}" var="classroom"> 
					<tr> 
<%-- 			 			<td><form:checkbox path="id" value="${classroom.classroom_id}"/></td>   --%>
						<td>${classroom.name}</td> 
					</tr> 
			  </c:forEach>
		      </tbody> 
	    </table></td> 
    </tr> 
 	<tr> 
		<td colspan="2"><input type="submit" value="Create & Save" onClick="closeWin()"/></td>
	</tr>
    <tr>
      <td colspan="2"> 
	    <input type="button" value="Create & Save1" onClick="closeWin()">
	   </td>
    </tr> 
</table>
</form:form> 
</body>
</html>