<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/13/2025
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<a href="/products/add">Add Product</a>
<table border="1">
  <tr>
    <th>Name</th>
    <th>Price</th>
    <th>Category</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="product" items="${products}">
    <tr>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>
        <c:forEach var="category" items="${categories}">
          <c:if test="${category.id == product.categoryId}">
            ${category.name}
          </c:if>
        </c:forEach>
      </td>
      <td>
        <a href="/products/${product.id}">Details</a>
        <a href="/products/edit/${product.id}">Edit</a>
        <a href="/products/delete/${product.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
