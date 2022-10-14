<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 14/10/2022
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate" method="get">
    <p><input type="text" name="firstParam"> <input type="text" name="secondParam"></p>
  <p>
    <input type="submit" value="Addition(+)" name="operator">
    <input type="submit" value="Subtraction(-)" name="operator">
    <input type="submit" value="Multiplication(*)" name="operator">
    <input type="submit" value="Division(/)" name="operator">
  </p>
</form>
<p>Result: ${result}</p>
</body>
</html>
