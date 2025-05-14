<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/13/2025
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<h1>Shopping Cart</h1>
<a href="/products">Back to Product List</a>
<table border="1">
    <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>
        <th>Action</th>
    </tr>
    <c:forEach var="item" items="${cart}">
        <tr>
            <td><img src="${item.product.image}" alt="${item.product.name}" width="100"></td>
            <td>${item.product.name}</td>
            <td>${item.product.price}</td>
            <td>${item.quantity}</td>
            <td>${item.product.price * item.quantity}</td>
            <td>
                <a href="/increase-quantity?id=${item.product.id}">Increase</a>
                <a href="/decrease-quantity?id=${item.product.id}">Decrease</a>
                <a href="/remove-from-cart?id=${item.product.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>Total: ${total}</h2>
</body>
</html>
