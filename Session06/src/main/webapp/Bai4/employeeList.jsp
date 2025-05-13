<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/12/2025
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Employee List</title>
</head>
<body>
<h1>Employee List</h1>
<a href="addEmployee.jsp">Add New Employee</a>
<form action="employees" method="get">
  <input type="text" name="name" placeholder="Search by name"/>
  <input type="number" name="id" placeholder="Search by ID"/>
  <button type="submit" name="action" value="search">Search</button>
</form>
<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Birthday</th>
    <th>Phone</th>
    <th>Email</th>
    <th>Salary</th>
    <th>Position</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="employee" items="${employees}">
    <tr>
      <td><c:out value="${employee.id}"/></td>
      <td><c:out value="${employee.name}"/></td>
      <td><c:out value="${employee.birthday}"/></td>
      <td><c:out value="${employee.phone}"/></td>
      <td><c:out value="${employee.email}"/></td>
      <td><c:out value="${employee.salary}"/></td>
      <td><c:out value="${employee.position}"/></td>
      <td>
        <a href="updateEmployee.jsp?id=${employee.id}">Edit</a>
        <form action="employees" method="post" style="display:inline;">
          <input type="hidden" name="id" value="${employee.id}"/>
          <button type="submit" name="action" value="delete">Delete</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
