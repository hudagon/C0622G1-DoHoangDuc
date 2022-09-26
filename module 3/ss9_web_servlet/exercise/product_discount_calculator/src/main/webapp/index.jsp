<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 26/09/2022
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form action="/pdc" method="post">
    <div>
      <h1>Product Discount Calculator</h1>
      <p>Product Description</p>
      <input type="text" name="productDescription">
      <p>List Price</p>
      <input type="text" name="listPrice">
      <p>Discount percent</p>
      <input type="text" name="discountPercent">
      <br>
      <button type="submit" name="calculateDiscount">Calculate Discount</button>
    </div>
  </form>
  </body>
</html>
