<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 17/10/2022
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Page</title>
</head>
<body>
<p>${mess}</p>
<table border="1">
    <tr>
        <th>Account</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <tr>
        <td>${user.getAccount()}</td>
        <td>${user.getName()}</td>
        <td>${user.getEmail()}</td>
    </tr>
</table>
</body>
</html>
