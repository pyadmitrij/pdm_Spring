<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="content">
    <tr>
        <td>
            <form method="GET" action="<c:url value="/main" />">
                <input class="button" type="submit" value="Main"/>
            </form>
        </td>
        <td>
            <form method="GET" action="<c:url value="/started" />">
                <input class="button" type="submit" value="Started"/>
            </form>
        </td>
        <td>
            <form method="GET" action="<c:url value="/salad" />">
                <input class="button" type="submit" value="Salad"/>
            </form>
        </td>
        <td>
            <form method="GET" action="<c:url value="/soup" />">
                <input class="button" type="submit" value="Soup"/>
            </form>
        </td>
        <td>
            <form method="GET" action="<c:url value="/side_dish" />">
                <input class="button" type="submit" value="Side dish"/>
            </form>
        </td>
        <td>
            <form method="GET" action="<c:url value="/desert" />">
                <input class="button" type="submit" value="Desert"/>
            </form>
        </td>
    </tr>
</table>
