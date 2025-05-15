<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/14/2025
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Employee</title>
</head>
<body>
<h2>Add New Employee</h2>
<%--@elvariable id="employee" type="java"--%>
<form:form action="/employees" method="post" modelAttribute="employee">
  <label for="name">Name:</label>
  <form:input path="name" id="name" required="true" /><br><br>

  <label for="email">Email:</label>
  <form:input path="email" id="email" required="true" /><br><br>

  <label for="position">Position:</label>
  <form:input path="position" id="position" required="true" /><br><br>

  <button type="submit">Add Employee</button>
</form:form>
</body>
</html>
