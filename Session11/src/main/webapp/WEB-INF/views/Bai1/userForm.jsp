<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/19/2025
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>User Form</title>
</head>
<body>
<h4>User Form</h4>
<%--@elvariable id="UserDTO" type="java"--%>
<form:form modelAttribute="UserDTO" action="/user-save" method="post">
  <div>
    <label for="name">Name:</label>
    <form:input path="name" />
    <br>
    <form:errors path="name" cssStyle="color: red;" />
  </div>
  <div>
    <label for="email">Email:</label>
    <form:input path="email" />
    <br>
    <form:errors path="email" cssStyle="color: red;" />
  </div>
  <div>
    <label for="phone">Phone:</label>
    <form:input path="phone" />
    <br>
    <form:errors path="phone" cssStyle="color: red;" />
  </div>
  <div>
    <label for="password">Password:</label>
    <form:password path="password" />
    <br>
    <form:errors path="password" cssStyle="color: red;" />
  </div>
  <div>
    <label for="status">Status:</label>
    <form:checkbox path="status" id="status" />
  </div>
  <div>
    <input type="submit" value="Submit" />
  </div>
</form:form>
</body>
</html>
