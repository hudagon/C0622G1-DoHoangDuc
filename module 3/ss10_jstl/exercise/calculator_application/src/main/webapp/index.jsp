<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 29/09/2022
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculate" method="get">
    <h1>Simple calculator!</h1>
    <p>First operand <input type="number" name="firstOperand"></p>
    <p>Operator:
        <select name="operator" id="operator">
            <option value="1">Addition</option>
            <option value="2">Subtraction</option>
            <option value="3">Multiplication</option>
            <option value="4">Division</option>
        </select>
    </p>
    <p>Second operand <input type="number" name="secondOperand"></p>
    <input type="submit" value="calculate!">
</form>
<c:if test="${resultServlet == 1.0/0}">
    Không chia được
</c:if>

<c:if test="${resultServlet != 1.0/0}">
    <p>Result here: ${resultStringServlet}${resultServlet}</p>
</c:if>
</body>
</html>
