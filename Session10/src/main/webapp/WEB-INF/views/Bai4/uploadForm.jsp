<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/17/2025
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Upload Avatar</title>
</head>
<body>
<h1>Upload Avatar</h1>
<form action="uploadAvatar" method="post" enctype="multipart/form-data">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="avatar">Avatar:</label>
    <input type="file" id="avatar" name="avatar" required><br><br>

    <button type="submit">Upload</button>
</form>
</body>
</html>
