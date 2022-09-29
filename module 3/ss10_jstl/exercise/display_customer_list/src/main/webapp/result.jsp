<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 29/09/2022
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer display</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <style>
        img {
            height: 100px;
            width: 100px;
        }
    </style>
</head>
<body>
<h1>List customer!</h1>
<table class="table table-dark">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach var="x" items="${customerListServlet}">
        <tr>
            <td>${x.getId()}</td>
            <td>${x.getName()}</td>
            <td>${x.getBirthday()}</td>
            <td>${x.getAddress()}</td>
            <td>
                <c:choose>
                    <c:when test="${x.getId() == 1}">
                        <img src="https://yt3.ggpht.com/ytc/AMLnZu8Rg-ccA-ospQ9XRf6l6ixZOlyaxC4Nikihx4rtaA=s900-c-k-c0x00ffffff-no-rj">
                    </c:when>
                    <c:when test="${x.getId() == 2}">
                        <img src="https://media.coolmate.me/cdn-cgi/image/quality=80/uploads/October2021/meme-cheems-25.jpg">
                    </c:when>
                    <c:when test="${x.getId() == 3}">
                        <img src="https://i.pinimg.com/236x/52/2e/e1/522ee1e9537992c3d0bbba977e2b120a.jpg">
                    </c:when>
                    <c:when test="${x.getId() == 4}">
                        <img src="https://i.pinimg.com/736x/d6/4c/b3/d64cb334bf6c5e2dae08f6c947757477.jpg">
                    </c:when>
                    <c:when test="${x.getId() == 5}">
                        <img src="https://i.pinimg.com/236x/b2/a7/2b/b2a72b082c6adbf28d8a4046ff9f54ab--gif-collection-frogs.jpg">
                    </c:when>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
