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
    <title>Add book</title>
</head>
<body>

<form:form method="post" modelAttribute="book">
    <div>
        <label for="title">title</label>
        <form:input id="title" path="title"/>
    </div>
    <div>
        <label for="rating">rating</label>
        <form:input id="rating" path="rating" type="number"/>
    </div>
    <div>
        <label for="description">description</label>
        <form:textarea id="description" path="description"/>
    </div>
    <div>
        <label for="publisher">publisher</label>
        <form:select id="publisher" path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>
    </div>
    <div>
        <label for="authors">authors</label>
        <form:select id="authors" path="authors" items="${authors}" multiple="true" itemValue="id" itemLabel="fullName"/>
    </div>
    <div>
        <input type="submit">
    </div>
</form:form>
</body>
</html>
