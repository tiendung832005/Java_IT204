<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/12/2025
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
<h1>Update Employee</h1>
<form action="employees" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="${param.id}"/>
    <label>Name:</label>
    <input type="text" name="name" value="${employee.name}" required/><br/>
    <label>Birthday:</label>
    <input type="date" name="birthday" value="${employee.birthday}" required/><br/>
    <label>Phone:</label>
    <input type="text" name="phone" value="${employee.phone}" required/><br/>
    <label>Email:</label>
    <input type="email" name="email" value="${employee.email}" required/><br/>
    <label>Salary:</label>
    <input type="number" name="salary" value="${employee.salary}" required/><br/>
    <label>Position:</label>
    <input type="text" name="position" value="${employee.position}" required/><br/>
    <button type="submit">Update</button>
</form>
</body>
</html>
