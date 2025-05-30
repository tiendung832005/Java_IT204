<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/29/2025
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User Registration</title>
</head>
<body>
<h1>User Registration</h1>
<form th:action="@{/register}" th:object="${user}" method="post">
    <div>
        <label for="name">Name:</label>
        <input type="text" id="name" th:field="*{name}" />
        <span th:if="${#fields.hasErrors('name')}" th:errors="*{name}"></span>
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" th:field="*{email}" />
        <span th:if="${#fields.hasErrors('email')}" th:errors="*{email}"></span>
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" th:field="*{password}" />
        <span th:if="${#fields.hasErrors('password')}" th:errors="*{password}"></span>
    </div>
    <button type="submit">Register</button>
</form>
</body>
</html>
