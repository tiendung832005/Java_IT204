<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/23/2025
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Tuổi</th>
        <th>Hành Động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.age}</td>
            <td>
                <a href="edit-student/${student.id}">Sửa</a> |
                <a href="delete-student/${student.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
