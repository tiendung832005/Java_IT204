<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/13/2025
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products in Category: ${category}</h1>
<p>Color: ${color}</p>
<p>Size: ${size}</p>
<ul>
    <c:forEach var="product" items="${products}">
        <li>${product}</li>
    </c:forEach>
</ul>
</body>
</html>
