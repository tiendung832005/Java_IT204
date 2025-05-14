<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/14/2025
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Add Course</title>
</head>
<body>
<h1>Add New Course</h1>
<form action="/courses/add" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required><br>
  <label for="description">Description:</label>
  <textarea id="description" name="description" required></textarea><br>
  <button type="submit">Add Course</button>
</form>
<a href="/courses">Back to Course List</a>
</body>
</html>
