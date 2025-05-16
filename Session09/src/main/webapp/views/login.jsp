<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/15/2025
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="/login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <br>
    <button type="submit">Login</button>
</form>
<p style="color: red;">${error}</p>
</body>
</html>
