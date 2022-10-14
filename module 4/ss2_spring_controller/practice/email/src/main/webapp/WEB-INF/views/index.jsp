<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 14/10/2022
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Email Validation</h1>
  <form action="/checkEmail" method="get">
    <p>Email: <input type="text" name="emailCheck"></p>
    <p><button type="submit">Check</button></p>
  </form>
  </body>
<p>Result: ${result}</p>
</html>
