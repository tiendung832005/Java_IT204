<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/28/2025
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Order Management</title>
</head>
<body>
<h1>Order Management</h1>

<h2>Add Order</h2>
<form action="/orders/add" method="post">
  <label for="orderId">Order ID:</label>
  <input type="text" id="orderId" name="orderId" required><br>
  <label for="productName">Product Name:</label>
  <input type="text" id="productName" name="productName" required><br>
  <label for="quantity">Quantity:</label>
  <input type="number" id="quantity" name="quantity" required><br>
  <button type="submit">Add Order</button>
</form>

<h2>Orders</h2>
<ul>
  <c var="order" items="${orders}">
    <li>
        ${order.orderId} - ${order.productName} - Quantity: ${order.quantity}
      <form action="/orders/edit" method="post" style="display:inline;">
        <input type="hidden" name="orderId" value="${order.orderId}">
        <input type="text" name="productName" value="${order.productName}" required>
        <input type="number" name="quantity" value="${order.quantity}" required>
        <button type="submit">Edit</button>
      </form>
      <a href="/orders/delete?orderId=${order.orderId}">Delete</a>
    </li>
  </c >
</ul>
</body>
</html>
