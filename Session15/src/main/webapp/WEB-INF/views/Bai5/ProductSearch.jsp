<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/29/2025
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Product Search</title>
</head>
<body>
<h1>Product Search</h1>
<form th:action="@{/search}" method="get">
  <label for="query">Search:</label>
  <input type="text" id="query" name="query" th:value="${query}" />
  <button type="submit">Search</button>
</form>

<div th:if="${error}">
  <p th:text="${error}" style="color: red;"></p>
</div>

<div th:if="${results != null}">
  <table th:if="${results.size() > 0}">
    <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="product : ${results}">
      <td th:text="${product.id}"></td>
      <td th:text="${product.name}"></td>
    </tr>
    </tbody>
  </table>
  <p th:if="${results.size() == 0}">No matching products found.</p>
</div>
</body>
</html>
