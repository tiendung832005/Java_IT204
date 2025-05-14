<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/14/2025
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Course List</title>
</head>
<body>
<h1>Course List</h1>
<a href="/courses/add">Add New Course</a>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Description</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="course" items="${courses}">
    <tr>
      <td>${course.id}</td>
      <td>${course.name}</td>
      <td>${course.description}</td>
      <td>
        <a href="/courses/delete/${course.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
