<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/28/2025
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>View Orders</title>
</head>
<body>
<h1>View Orders</h1>
<ul>
  <c:forEach var="order" items="${orders}">
    <li>${order.username} ordered ${order.quantity} of ${order.productName}</li>
  </c:forEach>
</ul>
<a href="/order">Place New Order</a>
</body>
</html>
