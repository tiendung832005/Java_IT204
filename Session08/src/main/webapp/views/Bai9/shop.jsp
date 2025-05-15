<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/14/2025
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Shop</title>
</head>
<body>
<h2>Shop</h2>
<p>${message}</p>
<table border="1">
  <thead>
  <tr>
    <th>Image</th>
    <th>Name</th>
    <th>Price</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="seed" items="${seeds}">
    <tr>
      <td><img src="${seed.imageUrl}" alt="${seed.seedsName}" style="max-width: 100px;"></td>
      <td>${seed.seedsName}</td>
      <td>${seed.price}</td>
      <td>
        <form action="/buy" method="post">
          <input type="hidden" name="seedId" value="${seed.id}" />
          <label for="quantity_${seed.id}">Quantity:</label>
          <input type="number" id="quantity_${seed.id}" name="quantity" min="1" required />
          <button type="submit">Buy</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
