<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/7/2025
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>Đăng ký</h2>
  <form action="">
    Họ tên: <input type="text" name="name" required><br>
    Email: <input type="email" name="email" required><br>
    Mật khẩu: <input type="password" name="password" required><br>
    <button type="submit">Đăng ký</button>
  </form>

<%
  if("POST".equalsIgnoreCase(request.getMethod())){
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if(name != null && email !=null && password != null){

%>
  <h3>Đăng ký thành công</h3>
<%
    }
  }
%>
</body>
</html>
