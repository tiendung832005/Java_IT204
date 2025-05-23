<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/19/2025
  Time: 9:34 PM
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
<%--@elvariable id="RegistrationDTO" type="java"--%>
<form:form modelAttribute="RegistrationDTO" action="/register" method="post">
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
    <label for="password">Mật khẩu:</label>
    <form:password path="password" />
    <br>
    <form:errors path="password" cssStyle="color: red;" />
  </div>
  <div>
    <input type="submit" value="Đăng ký" />
  </div>
</form:form>
</body>
</html>
