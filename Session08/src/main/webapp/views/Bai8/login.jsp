<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/14/2025
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form:form action="/login" method="post" modelAttribute="user">
  <label for="username">Username:</label>
  <form:input path="username" id="username" required="true" /><br><br>

  <label for="password">Password:</label>
  <form:password path="password" id="password" required="true" /><br><br>

  <button type="submit">Login</button>
</form:form>
<p>${message}</p>
</body>
</html>
