<%@ page import="com.data.session03.Bai9.UserManager" %>
<%@ page import="com.data.session03.Bai9.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/7/2025
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    UserManager userManager = (UserManager) application.getAttribute("userManager");
    List<User> users = userManager != null ? userManager.getUsers() : new ArrayList<>();
    String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách người dùng</title>
    <script>
        function confirmDelete(id) {
            if (confirm("Bạn có chắc chắn muốn xóa người dùng này?")) {
                window.location = "user?action=delete&id=" + id;
            }
        }
    </script>
</head>
<body>
<h2>Danh sách người dùng</h2>
<% if (message != null) { %>
<p style="color:green;"><%= message %></p>
<% } %>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Hành động</th>
    </tr>
    <% for (User u : users) { %>
    <tr>
        <td><%= u.getId() %></td>
        <td><%= u.getName() %></td>
        <td><%= u.getEmail() %></td>
        <td>
            <button onclick="confirmDelete(<%= u.getId() %>)">Xóa</button>
        </td>
    </tr>
    <% } %>
</table>
<br>
<a href="input.jsp">Thêm người dùng mới</a>
</body>
</html>

