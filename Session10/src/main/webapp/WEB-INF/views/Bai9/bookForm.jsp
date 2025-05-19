<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/18/2025
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Add Book</title>
</head>
<body>
<h1>Add Book</h1>
<form action="addBook" method="post" enctype="multipart/form-data">
  <label for="title">Title:</label>
  <input type="text" id="title" name="title" required><br><br>

  <label for="author">Author:</label>
  <input type="text" id="author" name="author" required><br><br>

  <label for="description">Description:</label>
  <textarea id="description" name="description" required></textarea><br><br>

  <label for="file">E-Book File:</label>
  <input type="file" id="file" name="file" required><br><br>

  <button type="submit">Add Book</button>
</form>
</body>
</html>
