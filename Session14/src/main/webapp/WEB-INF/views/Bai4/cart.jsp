<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/28/2025
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h1>Shopping Cart</h1>

<h2>Add Product</h2>
<form action="/cart/add" method="post">
    <label for="name">Product Name:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" required><br>
    <button type="submit">Add to Cart</button>
</form>

<h2>Cart</h2>
<ul>
    <c forEach var="product" items="${cart}">
        <li>
                ${product.name} - Quantity: ${product.quantity}
            <a href="/cart/delete?name=${product.name}">Remove</a>
        </li>
    </c>
</ul>

<h2>Products from Cookies</h2>
<ul>
    <c forEach var="product" items="${products}">
        <li>${product.name} - Quantity: ${product.quantity}</li>
    </c>
</ul>
</body>
</html>
