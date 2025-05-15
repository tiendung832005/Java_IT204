<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/14/2025
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
  <title>Register</title>
</head>
<body>
<h2>Register</h2>
<%--@elvariable id="user" type="java"--%>
<form:form action="/register" method="post" modelAttribute="user">
  <label for="username">Username:</label>
  <form:input path="username" id="username" required="true" /><br><br>

  <label for="password">Password:</label>
  <form:password path="password" id="password" required="true" /><br><br>

  <label for="email">Email:</label>
  <form:input path="email" id="email" required="true" /><br><br>

  <button type="submit">Register</button>
</form:form>
</body>
</html>
