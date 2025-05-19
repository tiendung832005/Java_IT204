<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/17/2025
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Form</title>
</head>
<body>
<h1>Enter Product Information</h1>
<form action="addProduct" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" required><br><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br><br>

    <button type="submit">Submit</button>
</form>
</body>
</html>
