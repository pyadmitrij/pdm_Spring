<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<body>
<div id="maket">
	<div id="opback"></div>
	<div id="wrapper">
		<header>
		<h1 id="text">Portal posts</h1>
		<h3 id="text">Author Dmitriy</h3>
			<security:authorize access="isAnonymous()">
				<spring:url var="authUrl" value="/static/j_spring_security_check" />
				<form method="post" class="signin" action="${authUrl}">
				<a href="<c:url value='/add_user'/>" id="home">Registration</a>
					<label for="email">email:</label> 
					<input id="email" name="j_username" type="text" value="email"
						onclick="if(this.value == 'email') this.value = ''"
						onblur="if(this.value == '') this.value = 'email'" /> 
					<label for="password">password:</label> 
					<input id="password" name="j_password" type="password" 
						value="password" onclick="if(this.value == 'password') this.value = ''"
						onblur="if(this.value == '') this.value = 'password'" /> 
					<input name="commit" type="submit" value="Login" />
				</form>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<div>
					<security:authentication property="principal.username" />
					<a id="logout" href="<c:url value='/j_spring_security_logout'/>">Logout</a>
<%-- 					<a id="logout" href="<c:url value='/user'/>">My profile</a> --%>
				</div>
			</security:authorize>
		</header>
		<security:authorize access="isAuthenticated()">
			<nav>
				<ul>
					<li><a href="<c:url value='/'/>" id="home">Home</a></li>
					<li>
					
					<a href="<c:url value='/add_post'/>" id="add_post">Add post</a>
					</li>
					<li><a href="<c:url value='/all_post'/>" id="all_post">All post</a></li>
					<li><a href="<c:url value='/all_my_post'/>" id="aal_my_post">All my post</a></li>
					<li><a href="<c:url value='/user'/>" id="user">My profile</a></li>
				</ul>
			</nav>
		</security:authorize>
		<div id="container">