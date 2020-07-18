<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 05.07.2020
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>form binded</title>
</head>
<body>

<form:form method="post" modelAttribute="person">
    <div>
        <label for="login">Login</label>
        <form:input id="login" path="login"/>
    </div>
    <div>
        <label for="email">Email</label>
        <form:input id="email" path="email" type="email"/>
    </div>
    <div>
        <label for="password">Password</label>
        <form:input id="password" path="password" type="password"/>
    </div>
    <div>
        <label for="yearOfBirth">yearOfBirth</label>
        <form:input id="yearOfBirth" path="yearOfBirth" type="number"/>
        <form:errors path="yearOfBirth" element="div"/>
    </div>
    <div>
        <input type="submit">
    </div>
</form:form>
</body>
</html>
