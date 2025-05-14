<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/13/2025
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<form action="/products/update" method="post">
  <input type="hidden" name="id" value="${product.id}">
  <label>Name:</label>
  <input type="text" name="name" value="${product.name}" required><br>
  <label>Price:</label>
  <input type="number" name="price" step="0.01" value="${product.price}" required><br>
  <label>Category:</label>
  <select name="categoryId">
    <c:forEach var="category" items="${categories}">
      <option value="${category.id}" <c:if test="${category.id == product.categoryId}">selected</c:if>>${category.name}</option>
    </c:forEach>
  </select><br>
  <button type="submit">Update</button>
</form>
</body>
</html>
