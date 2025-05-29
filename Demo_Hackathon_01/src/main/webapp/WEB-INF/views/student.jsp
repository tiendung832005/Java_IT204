<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/26/2025
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h1>Student List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Sex</th>
        <th>BOD</th>
        <th>Status</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.phone}</td>
            <td>${student.sex ? 'Male' : 'Female'}</td>
            <td>${student.bod}</td>
            <td>${student.status}</td>
            <td>
                <a href="update-student.jsp?id=${student.id}">Update</a>
                <a href="students?action=delete&id=${student.id}" onclick="return confirm('Are you sure you want to delete this student?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
