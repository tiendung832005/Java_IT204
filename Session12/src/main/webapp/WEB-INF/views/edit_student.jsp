<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/25/2025
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sửa Sinh Viên</title>
</head>
<body>
<h2>Sửa Sinh Viên</h2>
<form action="edit-student/${student.id}" method="post">
  Tên: <input type="text" name="name" value="${student.name}" required><br>
  Email: <input type="email" name="email" value="${student.email}" required><br>
  Tuổi: <input type="number" name="age" value="${student.age}" required><br>
  <button type="submit">Cập Nhật</button>
</form>
</body>
</html>
