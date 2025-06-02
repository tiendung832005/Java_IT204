<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/30/2025
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Checkout</title>
</head>
<body>
<h1>Checkout</h1>
<table>
  <thead>
  <tr>
    <th>Product Name</th>
    <th>Quantity</th>
    <th>Price</th>
    <th>Total</th>
  </tr>
  </thead>
  <tbody>
  <tr th:each="cart : ${cartItems}">
    <td th:text="${#lists.find(products, p -> p.id == cart.idProduct).productName}"></td>
    <td th:text="${cart.quantity}"></td>
    <td th:text="${#lists.find(products, p -> p.id == cart.idProduct).price}"></td>
    <td th:text="${#lists.find(products, p -> p.id == cart.idProduct).price * cart.quantity}"></td>
  </tr>
  </tbody>
</table>

<h2>Order Information</h2>
<form th:action="@{/place-order}" th:object="${order}" method="post">
  <input type="hidden" name="idUser" value="1" />
  <div>
    <label for="recipientName">Recipient Name:</label>
    <input type="text" id="recipientName" th:field="*{recipientName}" />
  </div>
  <div>
    <label for="address">Address:</label>
    <input type="text" id="address" th:field="*{address}" />
  </div>
  <div>
    <label for="phoneNumber">Phone Number:</label>
    <input type="text" id="phoneNumber" th:field="*{phoneNumber}" />
  </div>
  <button type="submit">Place Order</button>
</form>
</body>
</html>yn
