<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 13/10/2022
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
  <h1>Currency Convert</h1>
  <form action="/convert" method="post">
    <p>USD: <input type="text" name="amount"></p>
    <p>Rate: <input type="text" name="rate"></p>
    <button type="submit">Convert</button>
  </form>
  <p>Result: ${result}</p>
  </body>
</html>
