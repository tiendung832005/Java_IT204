<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/13/2025
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Product Details</title>
</head>
<body>
<h1>Product Details</h1>
<p>Name: ${product.name}</p>
<p>Price: ${product.price}</p>
<p>Category:
  <c:forEach var="category" items="${categories}">
    <c:if test="${category.id == product.categoryId}">
      ${category.name}
    </c:if>
  </c:forEach>
</p>
<a href="/products">Back to List</a>
</body>
</html>
