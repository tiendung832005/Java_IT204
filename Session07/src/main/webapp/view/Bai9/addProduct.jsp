<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/13/2025
  Time: 11:45 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Add Product</title>
</head>
<body>
<h1>Add Product</h1>
<form action="/products/save" method="post">
  <label>Name:</label>
  <input type="text" name="name" required><br>
  <label>Price:</label>
  <input type="number" name="price" step="0.01" required><br>
  <label>Category:</label>
  <select name="categoryId">
    <c:forEach var="category" items="${categories}">
      <option value="${category.id}">${category.name}</option>
    </c:forEach>
  </select><br>
  <button type="submit">Save</button>
</form>
</body>
</html>