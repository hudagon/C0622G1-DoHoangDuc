<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 28/09/2022
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hiển thị danh sách khách hàng</title>
    <style>
        img {
            height: 100px;
            width: 100px;
        }
    </style>
</head>
<body>
<table border="1px" width="100%" style="text-align: center">
    <caption><h1>Danh Sách Khách Hàng</h1></caption>
    <tr>
        <th>MSKH</th>
        <th style="width: 200px">Họ Và Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th style="width: 400px">Ảnh</th>
    </tr>

    <c:forEach var = "i" begin = "1" end = "5">
        <tr>
            <td>${ok}</td>
            <td>${ok}</td>
            <td>${ok}</td>
            <td>${ok}</td>
            <td>
                    ${ok}

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
