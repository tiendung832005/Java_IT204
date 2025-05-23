<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/20/2025
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Danh sách danh mục</title>
</head>
<body>
<h4>Danh Sách Danh Mục</h4>
<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Tên danh mục</th>
    <th>Trạng thái</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="category" items="${categories}">
    <tr>
      <td>${category.id}</td>
      <td>${category.categoryName}</td>
      <td>${category.status ? "Hoạt động" : "Không hoạt động"}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="/categories/add">Thêm danh mục mới</a>
</body>
</html>
