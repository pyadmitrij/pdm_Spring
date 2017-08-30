<%@include file="header.jsp" %>
<table>
    <tr>
        <td>${dish.name}</td>
    </tr>
    <tr>
        <td>${dish.category.category}</td>
    </tr>
    <tr>
        <td>${dish.cost}</td>
    </tr>
    <tr>
        <td>${dish.weight}</td>
    </tr>
    <tr>
        <td>Ingredients:</td>
    </tr>
    <tr>
        <td>
            <c:forEach items="${dish.idIngredient}" var="ingredient">
                <p>- ${ingredient.name}</p>
            </c:forEach>
        </td>

    </tr>
</table>

<%@include file="footer.jsp" %>
