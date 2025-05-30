<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/29/2025
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Cart</title>
</head>
<body>
<h1>Your Cart</h1>
<table>
  <thead>
  <tr>
    <th>Product ID</th>
    <th>Product Name</th>
    <th>Quantity</th>
    <th>Price</th>
    <th>Total</th>
  </tr>
  </thead>
  <tbody>
  <tr th:each="cart : ${cartItems}">
    <td th:text="${cart.idProduct}"></td>
    <td th:text="${#lists.find(products, p -> p.id == cart.idProduct).productName}"></td>
    <td th:text="${cart.quantity}"></td>
    <td th:text="${#lists.find(products, p -> p.id == cart.idProduct).price}"></td>
    <td th:text="${#lists.find(products, p -> p.id == cart.idProduct).price * cart.quantity}"></td>
  </tr>
  </tbody>
</table>
<p><strong>Total Price:</strong> <span th:text="${totalPrice}"></span></p>
</body>
</html>
