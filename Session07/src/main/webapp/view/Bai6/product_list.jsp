<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/13/2025
  Time: 9:14 PM
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
<a href="/cart">View Cart</a>
<table border="1">
  <tr>
    <th>Image</th>
    <th>Name</th>
    <th>Price</th>
    <th>Stock</th>
    <th>Action</th>
  </tr>
  <c:forEach var="product" items="${products}">
    <tr>
      <td><img src="${product.image}" alt="${product.name}" width="100"></td>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>${product.stock}</td>
      <td>
        <form action="/add-to-cart" method="get">
          <input type="hidden" name="id" value="${product.id}">
          <input type="number" name="quantity" min="1" value="1">
          <button type="submit">Add to Cart</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
