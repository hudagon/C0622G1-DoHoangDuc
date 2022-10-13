<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 13/10/2022
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  There are ${customerList.size()} customer(s) in list.
  <table border="1">
    <caption>Customers List</caption>
    <thead>
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Email</th>
      <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customerList}">
      <tr>
        <td>
          <c:out value="${c.id}"/>
        </td>
        <td>
          <a href="/detail?id=${c.id}">${c.name}</a>
        </td>
        <td>
          <c:out value="${c.email}"/>
        </td>
        <td>
          <c:out value="${c.address}"/>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </body>
</html>
