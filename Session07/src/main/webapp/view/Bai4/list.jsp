<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/13/2025
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Feedback List</title>
</head>
<body>
<h2>Feedback List</h2>
<table border="1">
  <tr>
    <th>Name</th>
    <th>Phone</th>
    <th>Address</th>
    <th>Content</th>
  </tr>
  <c:forEach var="feedback" items="${feedbackList}">
    <tr>
      <td>${feedback.name}</td>
      <td>${feedback.phone}</td>
      <td>${feedback.address}</td>
      <td>${feedback.content}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
