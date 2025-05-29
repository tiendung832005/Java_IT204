<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/28/2025
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="/login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${rememberedUsername}" required><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" value="${rememberedPassword}" required><br>
    <label for="rememberMe">Remember Me:</label>
    <input type="checkbox" id="rememberMe" name="rememberMe"><br>
    <button type="submit">Login</button>
</form>
<p style="color:red;">${error}</p>
</body>
</html>
