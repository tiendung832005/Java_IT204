<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/13/2025
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Feedback Form</title>
</head>
<body>
<h2>Feedback Form</h2>
<c:if test="${not empty error}">
  <p style="color: red;">${error}</p>
</c:if>
<form action="/form" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required><br><br>

  <label for="phone">Phone:</label>
  <input type="text" id="phone" name="phone"><br><br>

  <label for="address">Address:</label>
  <input type="text" id="address" name="address"><br><br>

  <label for="content">Content:</label>
  <textarea id="content" name="content" required></textarea><br><br>

  <button type="submit">Submit</button>
</form>
</body>
</html>