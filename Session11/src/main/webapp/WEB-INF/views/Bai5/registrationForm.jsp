<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/20/2025
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
<h4>Form Đăng Ký</h4>
<form:form modelAttribute="registrationDTO" action="/register" method="post">
    <div>
        <label for="name">Tên:</label>
        <form:input path="name" />
        <br>
        <form:errors path="name" cssStyle="color: red;" />
    </div>
    <div>
        <label for="email">Email:</label>
        <form:input path="email" />
        <br>
        <form:errors path="email" cssStyle="color: red;" />
    </div>
    <div>
        <label for="role">Vai trò:</label>
        <form:select path="role">
            <form:option value="user" label="Người dùng" />
            <form:option value="admin" label="Admin" />
        </form:select>
        <br>
        <form:errors path="role" cssStyle="color: red;" />
    </div>
    <div>
        <label for="adminInfo">Thông tin Admin:</label>
        <form:input path="adminInfo" />
        <br>
        <form:errors path="adminInfo" cssStyle="color: red;" />
    </div>
    <div>
        <input type="submit" value="Đăng ký" />
    </div>
</form:form>
</body>
</html>
