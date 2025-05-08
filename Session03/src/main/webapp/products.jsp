
<%@ page import="java.util.List" %>
<%@ page import="com.data.session03.Bai10.Product" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/8/2025
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Product> products = (List<Product>) application.getAttribute("products");
  String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Sản phẩm có sẵn</h2>

<% if (message != null) { %>
<p style="color:green;"><%= message %></p>
<% } %>

<table border="1">
  <tr><th>ID</th><th>Tên</th><th>Giá</th><th>Thao tác</th></tr>
  <% for (Product p : products) { %>
  <tr>
    <td><%= p.getId() %></td>
    <td><%= p.getName() %></td>
    <td><%= p.getPrice() %> VND</td>
    <td>
      <a href="cart?action=add&id=<%= p.getId() %>">Thêm vào giỏ</a>
    </td>
  </tr>
  <% } %>
</table>

<br><a href="cart.jsp">Xem giỏ hàng</a>
</body>
</html>
