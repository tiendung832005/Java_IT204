<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/14/2025
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h2>User Registration</h2>
<%--@elvariable id="user" type="java"--%>
<form:form action="/register" method="post" modelAttribute="user">
    <label for="name">Name:</label>
    <form:input path="name" id="name" />
    <form:errors path="name" cssClass="error" /><br><br>

    <label for="email">Email:</label>
    <form:input path="email" id="email" />
    <form:errors path="email" cssClass="error" /><br><br>

    <label for="phone">Phone:</label>
    <form:input path="phone" id="phone" />
    <form:errors path="phone" cssClass="error" /><br><br>

    <button type="submit">Register</button>
</form:form>
</body>
</html>
