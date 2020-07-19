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
    <title>Add proposition</title>
</head>
<body>

<form:form method="post" modelAttribute="proposition">
    <div>
        <label for="title">title</label>
        <form:input id="title" path="title"/>
        <form:errors path="title" element="div"/>
    </div>
    <div>
        <label for="description">description</label>
        <form:textarea id="description" path="description"/>
        <form:errors path="description" element="div"/>
    </div>
    <div>
        <input type="submit">
    </div>
    <div>
        <form:errors path="*" cssClass="error"></form:errors>
    </div>
</form:form>
</body>
</html>
