<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page  language="java" import="java.util.*,java.text.*"%>
<%@ page import="com.intita.domain.NewLessons"%>
<%@ page import="com.intita.domain.LessonCalendar"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	LessonCalendar newCalendar=(LessonCalendar) request.getAttribute("calendar");
    List<NewLessons> newLessons= (List<NewLessons>) request.getAttribute("lessonsList");
 %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/user.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lessons.css"/>

<title>Lessons</title>
 <meta http-equiv="Content-Style-Type" content="text/css"/>
<style type="text/css">
body
.dsb
{
 background-color:#7FFFD4
}
</style>
</head>

<jsp:include flush="true" page="header.jsp"/>
<form:form method="post" modelAttribute="date" action="enterData">
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><table id="tab" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="1%"></td>
        <td width="6%" style="color:orange">Date</td>
        <td width="5%">
        <form:select path="iSYear">
        <form:option value="2013" label="Year"/>
         <%for(int i=2013;i<=2100;i++){ %>
            <form:option value="<%=Integer.toString(i) %>" label="<%=Integer.toString(i) %>"/>
         <%} %>
        </form:select></td>
        <td width="2%"></td>
        <td width="6%">
        <form:select path="iSMonth">
           <form:option value="0" label="Month"/>
           <form:option value="0" label="January"/>
           <form:option value="1" label="February"/>
           <form:option value="2" label="March"/>
           <form:option value="3" label="April"/>
           <form:option value="4" label="May"/>
           <form:option value="5" label="June"/>
           <form:option value="6" label="July"/>
           <form:option value="7" label="August"/>
           <form:option value="8" label="September"/>
           <form:option value="9" label="October"/>
           <form:option value="10" label="November"/>
           <form:option value="11" label="December"/>
         </form:select></td>
         <td width="1%"></td>         
		 <td colspan="2"><input type="submit" value="Enter Date" class="button"/></td>       
         <td width="73%" align="right" style="color:orange"><h3>Schedule  
          <%=newCalendar.getiMonth()+1%>,
           <%=newCalendar.getiYear()%></h3></td>
        
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="mp" align="center" border="3" cellpadding="3" cellspacing="0" width="100%" >
      <tbody>
        <tr>
          <th id="p1">Sunday</th>
          <th id="p1">Monday</th>
          <th id="p1">Tuesday</th>
          <th id="p1">Wednesday</th>
          <th id="p1">Thursday</th>
          <th id="p1">Friday</th>
          <th id="p1">Saturday</th>
        </tr>
        <% int cnt =1;%>
        <%int f=1; %>
        <%for(int i=1;i<=newCalendar.getiTotalweeks();i++){%>
        <tr>
          <% for(int j=1;j<=7;j++)
            {
                if(cnt<newCalendar.getWeekStartDay() || (cnt-newCalendar.getWeekStartDay()+1)>newCalendar.getDays())//||j==1)
                { %>
                <td align="center"  width="14%"class="dsb">&nbsp;</td>
               <%}
                else
                { %>
                <td align="center"  width="14%"  id="day_<%=(cnt-newCalendar.getWeekStartDay()+1)%>">
                    <table  width="100%" border="1" cellspacing="0" cellpadding="0">
                    <% if(((cnt-newCalendar.getWeekStartDay()+1)>=1) ||((cnt-newCalendar.getWeekStartDay()+1)>=newCalendar.getDays()))
                           { %>
                         <tr>
                         <td colspan="2" id="it1"> <%=(cnt-newCalendar.getWeekStartDay()+1)%></td>
                         </tr>
                           <%} %>
                      <% int p=0;  
                          while ((f<newLessons.size())&&(p==0)){        
	                              if(newLessons.get(f).getData()==(cnt-newCalendar.getWeekStartDay()+1)){%> 
			            		    	  <tr id="it3"> 
 											<td><%=newLessons.get(f).getNewType()%></td>
 											<td><%=newLessons.get(f).getTime()%></td> 
 										  </tr> 
 										  <tr id="it4"> 
											<td colspan="2"><%=newLessons.get(f).getSubjectName()%></td> 
 										  </tr>	 
 										   <tr id="it4"> 
											<td><%=newLessons.get(f).getTeacerGroup()%></td> 
											<td><%=newLessons.get(f).getClassroomName()%></td> 
 										  </tr>	
									<%f++;%>
									<%}else{
									p=1;       
 									} %> 
 	            		 	<%} %>     
						
				   	</table>						
				</td>
              <%} %>
              <%  cnt++;%>
            <%  }%>
        </tr>
        <%}%>
      </tbody>
    </table></td>
  </tr>
</table>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</form:form>
<jsp:include flush="footer" page="footer.jsp"/>
