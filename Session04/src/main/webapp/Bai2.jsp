<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/8/2025
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Form Đăng Nhập</h2>
<form method="post" action="login.jsp">
    <label>Username:</label><br>
    <input type="text" name="username" /><br><br>
    <label>Password:</label><br>
    <input type="password" name="password" /><br><br>
    <input type="submit" value="Đăng nhập" />
</form>
<c:if test="${not empty param.username}">
    <c:choose>
        <c:when test="${param.username == 'admin' and param.password == '123456'}">
            <p style="color:green;">Đăng nhập thành công! Chào mừng <strong>${param.username}</strong>.</p>
        </c:when>
        <c:otherwise>
            <p style="color:red;">Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng thử lại.</p>
        </c:otherwise>
    </c:choose>
</c:if>
</body>
</html>
