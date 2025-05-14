<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/13/2025
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Feedback Result</title>
</head>
<body>
<h2>Feedback Result</h2>
<table border="1">
  <tr>
    <th>Name</th>
    <th>Phone</th>
    <th>Address</th>
    <th>Content</th>
  </tr>
  <tr>
    <td>${feedback.name}</td>
    <td>${feedback.phone}</td>
    <td>${feedback.address}</td>
    <td>${feedback.content}</td>
  </tr>
</table>
</body>
</html>
