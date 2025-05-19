<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/17/2025
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
<h1>Upload File to Cloud</h1>
<form action="uploadFile" method="post" enctype="multipart/form-data">
    <label for="file">File:</label>
    <input type="file" id="file" name="file" required><br><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br><br>

    <button type="submit">Upload</button>
</form>
</body>
</html>
