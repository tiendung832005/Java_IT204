<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/25/2025
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<a href="/products/add">Thêm sản phẩm</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Hình ảnh</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c: forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td><img src="${product.image}" alt="Image" width="50"></td>
            <td>
                <a href="/products/edit/${product.id}">Sửa</a> |
                <a href="/products/delete/${product.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c: >
    </tbody>
</table>
</body>
</html>
