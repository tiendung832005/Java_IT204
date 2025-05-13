<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/12/2025
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<h1>Add New Employee</h1>
<form action="employees" method="post">
    <input type="hidden" name="action" value="add"/>
    <label>Name:</label>
    <input type="text" name="name" required/><br/>
    <label>Birthday:</label>
    <input type="date" name="birthday" required/><br/>
    <label>Phone:</label>
    <input type="text" name="phone" required/><br/>
    <label>Email:</label>
    <input type="email" name="email" required/><br/>
    <label>Salary:</label>
    <input type="number" name="salary" required/><br/>
    <label>Position:</label>
    <input type="text" name="position" required/><br/>
    <button type="submit">Save</button>
</form>
</body>
</html>
