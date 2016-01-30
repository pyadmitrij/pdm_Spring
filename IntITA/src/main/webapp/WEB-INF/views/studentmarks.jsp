<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Marks</title>
</head>
<body>
	<form:form>
	<table>
		<tr>
			<td>Student:</td>
			<td>NAME SURNAME</td>
		</tr>
		<tr>
			<td>Group:</td>
			<td>A-1</td>
		</tr>
		<tr>
			<td><form:label path="s">Select a month:</form:label></td>
			<td><form:select path="s">
					<form:option value="1" label="January" />
					<form:option value="2" label="February" />
					<form:option value="3" label="March" />
					<form:option value="4" label="April" />
					<form:option value="5" label="May" />
					<form:option value="6" label="June" />
					<form:option value="7" label="July" />
					<form:option value="8" label="August" />
					<form:option value="9" label="September" />
					<form:option value="10" label="October" />
					<form:option value="11" label="November" />
					<form:option value="12" label="December" />
				</form:select></td>
		</tr>
		<tr>
			<td><form:label path="">Select a year:</form:label></td>
			<td><form:select path="">
					<form:option selected = "selected" value="1" label="2011" />
					<form:option value="2" label="2012" />
					<form:option value="3" label="2013" />
					<form:option value="4" label="2014" />
					<form:option value="5" label="2015" />
				</form:select></td>
		</tr>
		<tr>
			<td><input type="submit" value="OK" /></td>
		</tr>
		
	</table>
	</form:form>
	<table  width="100%" border="1">
		<tr>
			<th>Date</br>Subject</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th>
			<th>9</th><th>10</th><th>11</th><th>12</th><th>13</th><th>14</th><th>15</th><th>16</th>
		</tr>
		<tr>
			<th>JAVA</th><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td>
		</tr>
		<tr>
			<th>PHP</th><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td>
		</tr>
		<tr>
			<th>C/C++</th><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td>
		</tr>
		<tr>
			<th>English</th><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td>
		</tr>
	</table>
</body>
</html>