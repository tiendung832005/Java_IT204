<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/13/2025
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Product Details</title>
</head>
<body>
<h1>Product Details</h1>
<img src="${product.image}" alt="${product.name}" width="200"><br>
<p><strong>Name:</strong> ${product.name}</p>
<p><strong>Price:</strong> ${product.price}</p>
<p><strong>Stock:</strong> ${product.stock}</p>
<p><strong>Description:</strong> ${product.description}</p>
<a href="/products">Back to Product List</a>
</body>
</html>
