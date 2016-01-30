<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.List"%>
<%@page import="com.intita.domain.Folder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>File Manager ITA</title>
<link href="<%=request.getContextPath()%>/resources/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/fm.css"
	rel="stylesheet" type="text/css" />
</head>
<jsp:include flush="true" page="header.jsp" />
<div id="left">
	<h2>Folders</h2>
	<hr>
	<ul>
		<%
			StringBuilder strBuilder = new StringBuilder();
				for(Folder f : ((Folder) request.getAttribute("root")).getChildren())
					printFolderNode(f, strBuilder, (Integer) request.getAttribute("curFolder"));
		%>
		<%=strBuilder%>
	</ul>
</div>
<div id="right">
	<h2>Files</h2>
	<c:if test="${delFile}">
		<sf:form method="POST" enctype="multipart/form-data">
			<fieldset>
				<input name="file" type="file" /> <input name="comit" type="submit"
					value="Upload">
				<input name="curFolder" value="${curFolder}" type="hidden">
			</fieldset>
		</sf:form>
	</c:if>
	<hr>
	<table>
		<c:forEach var="file" items="${files}">
			<tr>
				<td><a href="fm?fileId=${file.id}">${file.name}</a></td>
				<td>
					<c:if
						test="${delFile}">
						<a href="fm/remove?fileId=${file.id}">del</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include flush="footer" page="footer.jsp" />

<%!void printFolderNode(Folder folder, StringBuilder strBuilder, Integer curFolder){
	if(folder == null)
		return;	
	strBuilder.append("<li");
	if(folder.getId() == curFolder)
		strBuilder.append(" class=\"selectedFolder\"");	
	strBuilder.append("><a href=\"http://localhost:8080/server/fm?folderId=")
		.append(folder.getId())
		.append("\">")
		.append(folder.getName())
		.append("</a></li>");
	List<Folder> children = folder.getChildren();
	if (!children.isEmpty()){
		strBuilder.append("<ul>");
		for (Folder f : children){
			printFolderNode(f, strBuilder, curFolder);
		}
		strBuilder.append("</ul>");
	}
}%>