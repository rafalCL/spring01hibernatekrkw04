<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 05.07.2020
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form unbinded</title>
</head>
<body>
    <form method="post">
        <div>
            <label for="login">Login</label>
            <input id="login" name="login">
        </div>
        <div>
            <label for="email">Email</label>
            <input id="email" name="email" type="email">
        </div>
        <div>
            <label for="password">Password</label>
            <input id="password" name="password" type="password">
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</body>
</html>
