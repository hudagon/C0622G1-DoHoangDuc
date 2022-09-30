<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 30/09/2022
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find product</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Find product page</h1>
<p>
    <a href="/product">Back to the list page</a>
</p>
<form action="/product?action=find" method="post">
    <fieldset>
        <legend>Find according to:</legend>
        <table>
            <tr>
                <td><input type="radio" name="option" value="id" onclick="openInput(this.value)">ID:
                </td>
                <td><input type="text" name="id" id="id" disabled="disabled">
                </td>
                <td>Find exactly</td>
            </tr>
            <tr>
                <td><input type="radio" name="option" value="name" onclick="openInput(this.value)">Name:
                </td>
                <td><input type="text" name="name" id="name" disabled="disabled"></br>
                </td>
                <td>Find almost</td>
            </tr>
            <tr>
                <td><input type="radio" name="option" value="Price" onclick="openInput(this.value)">Price: From
                </td>
                <td><input type="number" name="minPrice" id="minPrice" disabled="disabled">To
                </td>
                <td><input type="number" name="maxPrice" id="maxPrice" disabled="disabled">
                </td>
            </tr>
            <tr>
                <td><input type="radio" name="option" value="producer" onclick="openInput(this.value)">Manufacturer:
                </td>
                <td><input type="text" name="producer" id="producer" disabled="disabled">
                </td>
                <td>Find almost</td>
            </tr>
            <tr>
                <td><input type="submit" value="Find product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
<script>
    let inputId = ["id", "name", "minPrice", "maxPrice", "producer"];
    function openInput(value) {
        for (let element of inputId) {
            document.getElementById(element).disabled = !element.includes(value);
        }
    }
</script>
</html>