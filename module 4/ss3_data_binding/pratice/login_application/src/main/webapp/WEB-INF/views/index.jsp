<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 17/10/2022
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h2>Login page</h2>
  <form:form method="post" action="/login" modelAttribute="login">
    <p>Username: <form:input path="account"></form:input></p>
    <p>Password: <form:input path="password"></form:input></p>
    <button type="submit">Login</button>
  </form:form>
  </body>
</html>
