<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/26/2025
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<h1>Update Student</h1>
<form method="post" action="students">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${param.id}">
    <label>Name:</label>
    <input type="text" name="name" required><br>
    <label>Email:</label>
    <input type="email" name="email" required><br>
    <label>Phone:</label>
    <input type="text" name="phone" required><br>
    <label>Sex:</label>
    <select name="sex">
        <option value="true">Male</option>
        <option value="false">Female</option>
    </select><br>
    <label>BOD:</label>
    <input type="date" name="bod"><br>
    <label>Avatar:</label>
    <input type="text" name="avatar"><br>
    <label>Status:</label>
    <select name="status">
        <option value="ACTIVE">ACTIVE</option>
        <option value="INACTIVE">INACTIVE</option>
    </select><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
