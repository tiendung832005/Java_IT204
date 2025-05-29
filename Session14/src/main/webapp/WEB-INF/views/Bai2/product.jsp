<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/28/2025
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
<h1>Product Management</h1>

<h2>Add Product</h2>
<form action="/products" method="post">
    <label for="name">Product Name:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" required><br>
    <button type="submit">Add Product</button>
</form>

<h2>Product List</h2>
<ul>
    <c forEach var="product" items="${products}">
        <li>
                ${product.name} - $${product.price}
            <a href="/products/delete?name=${product.name}">Delete</a>
        </li>
    </c>
</ul>
</body>
</html>
