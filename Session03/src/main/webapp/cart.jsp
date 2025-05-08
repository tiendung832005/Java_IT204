<%@ page import="com.data.session03.Bai10.Product" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/8/2025
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CartManager cart = (CartManager) session.getAttribute("cart");
    List<Product> items = cart != null ? cart.getCart() : new ArrayList<>();
    double total = cart != null ? cart.getTotalPrice() : 0;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
</head>
<body>
<h2>Giỏ hàng của bạn</h2>

<table border="1">
    <tr><th>ID</th><th>Tên</th><th>Giá</th><th>Thao tác</th></tr>
    <% for (Product p : items) { %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %> VND</td>
        <td>
            <a href="cart?action=remove&id=<%= p.getId() %>">Xóa</a>
        </td>
    </tr>
    <% } %>
</table>

<h3>Tổng cộng: <%= total %> VND</h3>

<br><a href="products.jsp">Quay lại danh sách sản phẩm</a>
</body>
</html>
