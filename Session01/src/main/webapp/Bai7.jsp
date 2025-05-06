<%@ page import="com.data.session01.Bai7.StudentTicket" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/5/2025
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách học sinh đăng ký vé xe</h2>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Họ và tên</th>
        <th>Lớp</th>
        <th>Loại xe</th>
        <th>Biển số xe</th>
    </tr>
    <%
        List<StudentTicket> students = (List<StudentTicket>) request.getAttribute("studentList");
        for (StudentTicket s : students) {
    %>
    <tr>
        <td><%= s.getFullName() %></td>
        <td><%= s.getClassName() %></td>
        <td><%= s.getVehicleType() %></td>
        <td><%= s.getLicensePlate() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
