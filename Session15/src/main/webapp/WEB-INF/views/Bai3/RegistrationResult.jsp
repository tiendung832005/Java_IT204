<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/29/2025
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Registration Result</title>
</head>
<body>
<h1>Registration Successful</h1>
<p>Name: <span th:text="${user.name}"></span></p>
<p>Email: <span th:text="${user.email}"></span></p>
</body>
</html>
