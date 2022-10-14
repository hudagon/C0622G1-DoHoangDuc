<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 14/10/2022
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich Spices</h1>
<form action="/spices" method="get">
    <label>
        <span>Lettuce</span>
        <input type="checkbox" name="spices" value="Lettuce">
    </label>

    <label>
        <span>Tomato</span>
        <input type="checkbox" name="spices" value="Tomato">
    </label>

    <label>
        <span>Mustard</span>
        <input type="checkbox" name="spices" value="Mustard">
    </label>

    <label>
        <span>Sprouts</span>
        <input type="checkbox" name="spices" value="Sprouts">
    </label>
    <hr>
    <button type="submit">Save</button>
</form>
<c:if test="${spices != null}">
    <c:forEach var="x" items="${spices}" varStatus="count">
        <p>The number ${count.getCount()} spice is: ${x}</p>
    </c:forEach>
</c:if>
<br>
</body>
</html>
