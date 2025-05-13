<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/12/2025
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="register" method="post">
    <label>Username:</label>
    <input type="text" name="username" required/><br/>
    <label>Password:</label>
    <input type="password" name="password" required/><br/>
    <label>Email:</label>
    <input type="email" name="email"/><br/>
    <label>Phone:</label>
    <input type="text" name="phone"/><br/>
    <button type="submit">Register</button>
</form>
<p><a href="login">Already have an account? Login here</a></p>
</body>
</html>
