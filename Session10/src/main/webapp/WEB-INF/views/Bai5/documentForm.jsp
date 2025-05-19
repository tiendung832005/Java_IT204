<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/17/2025
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Upload Document</title>
</head>
<body>
<h1>Upload Document</h1>
<form action="uploadDocument" method="post" enctype="multipart/form-data">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br><br>

    <label for="file">File (PDF only):</label>
    <input type="file" id="file" name="file" accept=".pdf" required><br><br>

    <button type="submit">Upload</button>
</form>
</body>
</html>
