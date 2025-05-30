<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/29/2025
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Student List</title>
  <style>
    table {
      width: 100%;
      border-collapse: collapse;
    }
    th, td {
      border: 1px solid black;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
<h1>Student List</h1>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Class</th>
    <th>Email</th>
    <th>Address</th>
    <th>Phone</th>
  </tr>
  </thead>
  <tbody>
  <tr th:each="student : ${students}">
    <td th:text="${student.id}"></td>
    <td th:text="${student.name}"></td>
    <td th:text="${student.age}"></td>
    <td th:text="${student.className}"></td>
    <td th:text="${student.email}"></td>
    <td th:text="${student.address}"></td>
    <td th:text="${student.phone}"></td>
  </tr>
  </tbody>
</table>
</body>
</html>