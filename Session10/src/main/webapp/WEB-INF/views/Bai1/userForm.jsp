<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/17/2025
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<h1>Nhập Thông Tin Cá Nhân</h1>
<form action="submitForm" method="post">
    <label for="name">Tên:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="age">Tuổi:</label>
    <input type="number" id="age" name="age" required><br><br>

    <label for="address">Địa chỉ:</label>
    <input type="text" id="address" name="address" required><br><br>

    <button type="submit">Gửi</button>
</form>
</body>
</html>
