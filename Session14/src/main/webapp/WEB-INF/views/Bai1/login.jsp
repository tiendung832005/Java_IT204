<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/28/2025
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h1>Đăng nhập</h1>
<form action="/login" method="post">
    <label for="username">Tên người dùng:</label>
    <input type="text" id="username" name="username" required><br>
    <label for="password">Mật khẩu:</label>
    <input type="password" id="password" name="password" required><br>
    <button type="submit">Đăng nhập</button>
</form>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
</body>
</html>
