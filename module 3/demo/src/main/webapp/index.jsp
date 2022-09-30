<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 30/09/2022
  Time: 07:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Máy tính</title>
</head>
<body>
<h1>Máy tính</h1>
<legend>
    <form action="/tinhtoan" method="get">
        <p>Số thứ 1: <input type="number" name="soThuNhat"></p>
        <p>Toán tử:
            <select name="toanTu">
                <option value="1">Cộng</option>
                <option value="2">Trừ</option>
                <option value="3">Nhân</option>
                <option value="4">Chia</option>
            </select>
        </p>
        <p>Số thứ 2: <input type="number" name="soThuHai"></p>
        <input type="submit">
    </form>
  <p>Kết quả là: ${ketQua123123123123}</p>
</legend>
</body>
</html>
