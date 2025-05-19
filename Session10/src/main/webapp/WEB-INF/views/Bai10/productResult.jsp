<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/18/2025
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Result</title>
</head>
<body>
<h1>Product Result</h1>
<p>${message}</p>
<c:if test="${not empty product}">
    <p><strong>Name:</strong> ${product.name}</p>
    <p><strong>Price:</strong> ${product.price}</p>
    <p><strong>Stock:</strong> ${product.stock}</p>
    <p><strong>Image:</strong> <img src="${product.image}" alt="Product Image" width="200"></p>
</c:if>
</body>
</html>
