<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/14/2025
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Shop</title>
</head>
<body>
<h2>Shop</h2>
<table border="1">
  <thead>
  <tr>
    <th>Image</th>
    <th>Name</th>
    <th>Price</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="seed" items="${seeds}">
    <tr>
      <td><img src="${seed.imageUrl}" alt="${seed.seedsName}" style="max-width: 100px;"></td>
      <td>${seed.seedsName}</td>
      <td>${seed.price}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
