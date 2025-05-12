<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/11/2025
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Nhập Thông Tin Sinh Viên</h2>

<form action="student" method="post">
    Tên: <input type="text" name="name" value="${param.name}"><br><br>
    Tuổi: <input type="text" name="age" value="${param.age}"><br><br>
    Địa chỉ: <input type="text" name="address" value="${param.address}"><br><br>
    <input type="submit" value="Gửi">
</form>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>
