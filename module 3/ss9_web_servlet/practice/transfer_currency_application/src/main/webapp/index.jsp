<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 26/09/2022
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert currency</title>
</head>
<body>
    <form method="post" action="/cc">
        <div>
            <h1>Currency Converter!</h1>
            <div>
                <p>Rate:</p>
                <input type="text" name="rate">
                <p>USD:</p>
                <input type="text" name="currency">
            </div>
            <button type="submit">Converter</button>
        </div>
    </form>
</body>
</html>
