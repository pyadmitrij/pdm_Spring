<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Marks</title>
</head>
<body>
	<table> 
 			<tr>
			<td><label>Teacher:</label></td>
			<td><label>NAME SURNAME</label></td>
		</tr>
		<tr>
			<td><label>Select subject: </label></td>
			<td><select>
					<c:forEach items="${subjects}" var="subject">
						<option>Subject: ${subject.subjectName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><label>Select group:</label></td>
			<td><select>
					<c:forEach items="${groups}" var="group">
						<option>${group.name}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><label>Select a month:</label></td>
			<td><select>
					<option selected = "selected" value="1" label="January" />
					<option value="2" label="February" />
					<option value="3" label="March" />
					<option value="4" label="April" />
					<option value="5" label="May" />
					<option value="6" label="June" />
					<option value="7" label="July" />
					<option value="8" label="August" />
					<option value="9" label="September" />
					<option value="10" label="October" />
					<option value="11" label="November" />
					<option value="12" label="December" />
				</select></td>
		</tr>
		<tr>
			<td><label>Select a year:</label></td>
			<td><select>
					<option selected = "selected" value="1" label="2011" />
					<option value="2" label="2012" />
					<option value="3" label="2013" />
					<option value="4" label="2014" />
					<option value="5" label="2015" />
				</select></td>
		</tr>
		<tr>
			<td><input type="submit" value="SUBMIT" /></td>
		</tr>
		
	</table>
	<table  width="100%" border="1">
		<tr>
			<th rowspan=2>STUDENT NAME</th><th colspan=16>DATE</th>
		</tr>
		<tr>
			<th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th>
			<th>9</th><th>10</th><th>11</th><th>12</th><th>13</th><th>14</th><th>15</th><th>16</th>
		</tr>
		<tr>
			<th>USER_1</th><td><c:out value="${obj.mark}" /></td><td></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td></td><td><c:out value="${obj.mark}" /></td>
			<td></td><td><c:out value="${obj.mark}" /></td><td></td><td><c:out value="${obj.mark}" /></td>
		</tr>
		<tr>
			<th>USER_2</th><td></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td></td><td><c:out value="${obj.mark}" /></td><td></td>
			<td></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td>
		</tr>
		<tr>
			<th>USER_3</th><td><c:out value="${obj.mark}" /></td><td></td><td><c:out value="${obj.mark}" /></td>
			<td></td><td><c:out value="${obj.mark}" /></td><td></td>
			<td><c:out value="${obj.mark}" /></td><td></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td></td><td><c:out value="${obj.mark}" /></td><td></td>
		</tr>
		<tr>
			<th>USER_4</th><td><c:out value="${obj.mark}" /></td><td><c:out value="${obj.mark}" /></td><td></td>
			<td><c:out value="${obj.mark}" /></td><td></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td><td></td><td><c:out value="${obj.mark}" /></td>
			<td></td><td><c:out value="${obj.mark}" /></td><td></td>
			<td><c:out value="${obj.mark}" /></td><td></td><td><c:out value="${obj.mark}" /></td>
			<td><c:out value="${obj.mark}" /></td>
		</tr>
 	</table>
</body>
</html>