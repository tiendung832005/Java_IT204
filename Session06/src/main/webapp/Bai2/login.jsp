<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/12/2025
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
    <label>Username:</label>
    <input type="text" name="username" required/><br/>
    <label>Password:</label>
    <input type="password" name="password" required/><br/>
    <button type="submit">Login</button>
</form>
<p><a href="register">Don't have an account? Register here</a></p>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
</body>
</html>
