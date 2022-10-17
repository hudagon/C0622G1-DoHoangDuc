<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 17/10/2022
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <table border="1">
   <tr>
     <th>ID</th>
     <th>Name</th>
     <th>Contact number</th>
   </tr>
   <tr>
     <td>${employeeId}</td>
     <td>${employeeName}</td>
     <td>${employeeContactNumber}</td>
   </tr>
 </table>
  <button><a href="/formCreate" style="text-decoration: none">Create</a> </button>
  </body>
</html>
