<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/11/2025
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Đăng nhập</h2>
<form action="login" method="post">
  <label>Tên người dùng:</label>
  <input type="text" name="username" required><br><br>
  <label>Mật khẩu:</label>
  <input type="password" name="password" required><br><br>
  <input type="submit" value="Đăng nhập">
</form>
<p style="color:red">${error}</p>
</body>
</html>
