<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/6/2025
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.data.session02.Bai6.Product" %>
<%
    Product p = (Product) request.getAttribute("product");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Cập nhật sản phẩm</title>
</head>
<body>
<h2>Cập nhật sản phẩm</h2>

<% if (error != null) { %>
<p style="color: red;"><%= error %></p>
<% } %>

<form method="post" action="products">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= p.getId() %>">

    Tên: <input type="text" name="name" value="<%= p.getName() %>" required /><br><br>
    Giá: <input type="number" name="price" step="0.01" value="<%= p.getPrice() %>" required /><br><br>
    <input type="submit" value="Cập nhật">
</form>

<a href="products">Quay lại danh sách</a>
</body>
</html>
