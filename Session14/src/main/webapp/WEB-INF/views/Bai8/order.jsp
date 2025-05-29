<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/28/2025
  Time: 9:30 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Place Order</title>
</head>
<body>
<h1>Place Order</h1>
<form action="/order/place" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br>
  <label for="productName">Product Name:</label>
  <input type="text" id="productName" name="productName" required><br>
  <label for="quantity">Quantity:</label>
  <input type="number" id="quantity" name="quantity" required><br>
  <button type="submit">Place Order</button>
</form>
<p style="color:green;">${message}</p>
<a href="/order/view">View Orders</a>
</body>
</html>
