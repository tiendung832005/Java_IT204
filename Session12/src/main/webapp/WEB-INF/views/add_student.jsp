<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/25/2025
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Thêm Sinh Viên</title>
</head>
<body>
<h2>Thêm Sinh Viên</h2>
<form action="add-student" method="post">
  Tên: <input type="text" name="name" required><br>
  Email: <input type="email" name="email" required><br>
  Tuổi: <input type="number" name="age" required><br>
  <button type="submit">Thêm</button>
</form>
</body>
</html>
