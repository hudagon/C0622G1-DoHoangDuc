<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 17/10/2022
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>SETTINGS</h1>
<hr>
<form:form action="/email/showEmailSetting" method="get">
    <p>Email Setting:
        <select name="signature" >
            <option>--</option>
            <c:forEach var="x" items="${signatureList}">
                <option value="${x}">${x}</option>
            </c:forEach>
        </select>
        <button type="submit">Show</button>
    </p>
</form:form>
<form:form action="/email/saveSetting" method="post" modelAttribute="emailSetting">
    <p>Languages: <form:select path="language" value="${emailSetting.language}">
        <form:options items="${languageList}"/>
    </form:select>
    </p>
    <p>Page Size: Show <form:select path="pageSize" value="${emailSetting.pageSize}"
                                    items="${pageSizeList}"/> emails per page</p>
    <p>Spams filter: <form:checkbox path="spamsFilter" value="${emailSetting.spamsFilter}"/></p>
    <p>Signature: <form:textarea path="signature" value="${emailSetting.signature}"/></p>
    <button type="submit">Add</button>
</form:form>
<h3>${mess}</h3>
</body>
</html>
