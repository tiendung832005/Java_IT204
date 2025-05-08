<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/7/2025
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Bài 4</h2>
    <form action="">
        Số thứ nhất <input type="number" name="num1" required><br>
        Số thứ hai <input type="number" name="num2" required><br>
    </form>

<%
    String n1 = request.getParameter("num1");
    String n2 = request.getParameter("num2");
    if(n1 != null && n2 != null) {
        try{
            int a = Integer.parseInt(n1);
            int b = Integer.parseInt(n2);
%>
            <h3>Kết quả:</h3>
            <p>Tổng: <%= a + b %></p>
<%
    }catch (NumberFormatException e){
%>
    <p>Vui lòng nhập 2 số hợp lệ</p>
<%
        }
    }
%>
</body>
</html>
