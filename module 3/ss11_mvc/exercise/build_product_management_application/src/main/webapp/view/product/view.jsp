<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 01/10/2022
  Time: 08:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product's details</title>
</head>
<body>
<h1>View details page</h1>
<table class="table table-dark">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturer</th>
    </tr>
    <tr>
        <td>${products.get(idToShowDetails - 1).getId()}</td>
        <td>${products.get(idToShowDetails - 1).getName()}</td>
        <td>${products.get(idToShowDetails - 1).getPrice()}</td>
        <td>${products.get(idToShowDetails - 1).getDescription()}</td>
        <td>${products.get(idToShowDetails - 1).getManufacturer()}</td>
    </tr>
</table>
</body>
</html>
