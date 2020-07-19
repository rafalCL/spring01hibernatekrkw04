<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 05.07.2020
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>lista propozycji ksiazek</title>
</head>
<body>
<h1>Propozycje ksiazek:</h1>
<ul>
    <table border="1">
        <tr><th>Title</th><th>Description</th><th>Actions</th></tr>
    <c:forEach items="${propositions}" var="b">
        <tr>
            <td>${b.title}</td>
            <td>${b.description}</td>
            <td><a href="<c:url value="/proposition/edit/${b.id}"/>">Edit</a> <a href="<c:url value="/proposition/delete/${b.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</ul>
</body>
</html>
