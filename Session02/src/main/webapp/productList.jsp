<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.data.session02.Bai6.Product" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>
<form method="post" action="products">
    ID: <input type="number" name="id" required />
    Tên: <input type="text" name="name" required />
    Giá: <input type="number" step="0.01" name="price" required />
    <input type="submit" value="Thêm sản phẩm" />
</form>

<h2>Danh sách sản phẩm</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Hành động</th>
    </tr>
    <% for(Product p : products) { %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %></td>
        <td>
            <a href="products?action=edit&id=<%= p.getId() %>">Sửa</a>
        </td>
    </tr>
    <% } %>
    <td>
        <a href="products?action=edit&id=<%= p.getId() %>">Sửa</a> |
        <form method="post" action="products" style="display:inline;"
              onsubmit="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="id" value="<%= p.getId() %>">
            <input type="submit" value="Xóa">
        </form>
    </td>
</table>

</body>
</html>
