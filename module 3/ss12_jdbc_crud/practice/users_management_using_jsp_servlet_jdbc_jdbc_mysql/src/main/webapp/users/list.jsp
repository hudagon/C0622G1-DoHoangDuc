<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 03/10/2022
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
    <form action="/users?action=search" method="post">
        <input type="text" name="searchCountry">
        <input type="submit" value="Search">
    </form>
    <p>Sort by <select name="selectSort">
        <option value="1">By name</option>
        <option>By something that not available now</option>
    </select>
        <button><a href="/users?action=sort&selectSort=selectSort">Sort</a></button>
    </p>
    <c:if test="${listUser.size()==0}">
        <p align="center">Can't found any users</p>
    </c:if>
    <a href="/users">Reload page</a>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p align="center">${messSort}</p>
</div>
</body>
</html>
