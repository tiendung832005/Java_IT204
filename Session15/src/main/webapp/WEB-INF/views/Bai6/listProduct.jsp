<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/29/2025
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <tr th:each="product : ${products}">
    <td th:text="${product.id}"></td>
    <td th:text="${product.productName}"></td>
    <td th:text="${product.price}"></td>
    <td>
      <a th:href="@{/product-detail/{id}(id=${product.id})}">View Details</a>
    </td>
  </tr>
  </tbody>
</table>
</body>
</html>
