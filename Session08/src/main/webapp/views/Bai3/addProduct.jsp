<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/14/2025
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Product</title>
</head>
<body>
<h2>Add New Product</h2>
<form action="/products/add" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required><br><br>
  <label for="quantity">Quantity:</label>
  <input type="number" id="quantity" name="quantity" required><br><br>
  <label for="price">Price:</label>
  <input type="number" step="0.01" id="price" name="price" required><br><br>
  <button type="submit">Add Product</button>
</form>
</body>
</html>
