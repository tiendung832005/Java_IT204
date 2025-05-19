<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/17/2025
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Project</title>
</head>
<body>
<h1>Create Project</h1>
<form action="createProject" method="post" enctype="multipart/form-data">
    <label for="name">Project Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br><br>

    <label for="documents">Upload Documents:</label>
    <input type="file" id="documents" name="documents" multiple required><br><br>

    <button type="submit">Create Project</button>
</form>
</body>
</html>
