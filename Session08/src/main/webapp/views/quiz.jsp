<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/14/2025
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Quiz</title>
</head>
<body>
<h2>Quiz</h2>
<img src="${question.imageUrl}" alt="Question Image" style="max-width: 300px; max-height: 300px;"><br><br>

<form action="/guess" method="post">
  <label for="answer">Your Answer:</label>
  <input type="text" id="answer" name="answer" required><br><br>
  <button type="submit">Đoán</button>
</form>

<p>${message}</p>

<c:if test="${showRetry}">
  <form action="/quiz" method="get">
    <button type="submit">Chơi lại</button>
  </form>
</c:if>
</body>
</html>
