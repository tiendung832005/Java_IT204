<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/7/2025
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Bài 3</h2>
    <button type="submit">Chuyển đến trang chào mừng</button>

    <%
        if("POST".equalsIgnoreCase(request.getMethod())){


    %>
        <jsp:forward page="welcome.jsp"></jsp:forward>
    <%
        }
    %>
</body>
</html>
