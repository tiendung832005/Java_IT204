<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/11/2025
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sửa thông tin sinh viên</h2>
<form action="updateStudent" method="post">
  <input type="hidden" name="id" value="${student.id}">
  Tên: <input type="text" name="name" value="${student.name}"><br><br>
  Tuổi: <input type="text" name="age" value="${student.age}"><br><br>
  Địa chỉ: <input type="text" name="address" value="${student.address}"><br><br>
  <input type="submit" value="Cập nhật">
</form>
</body>
</html>
