<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/7/2025
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.io.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Giai đoạn khởi tạo--%>
<%!
    public void jspInit(){
    System.out.println("Giai đoạn khởi tạo trong jsp");
}
%>

<%--Giai đoạn hủy--%>
<%!
    public void jspDestroy(){
        System.out.println("Giai đoạn hủy trong jsp");
    }
%>

<%
    System.out.println("Giai đoạn Service trong jsp");
%>
</body>
</html>
