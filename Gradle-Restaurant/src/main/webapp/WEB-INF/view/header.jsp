<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<body>
<div id="maket">
    <div id="opback"></div>
    <div id="wrapper">
        <header>
            <div class="header">
                <div class="name_header"><img src="resources/img/Hetman.png"/></div>
                <div class="contacts_header">
                    <p>city: Vinnitsa, Ostrvskogo, 35</p>
                    <p>Phone: (0432) 69-96-88</p>
                </div>
                <nav>
                    <ul>
                        <li><a href="<c:url value='/'/>" id="home">Home</a></li>
                        <li><a href="<c:url value='/menu'/>" id="menu">Menu</a></li>
                        <li><a href="<c:url value='/users'/>" id="users">Employees</a></li>
                        <li><a href="<c:url value='/schema'/>" id="schema">Schema</a></li>
                        <li><a href="<c:url value='/contacts'/>" id="contacts">Contacts</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <div id="container">