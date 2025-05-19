<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/18/2025
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Book Result</title>
</head>
<body>
<h1>Book Result</h1>
<p>${message}</p>
<c:if test="${not empty book}">
  <p><strong>Title:</strong> ${book.title}</p>
  <p><strong>Author:</strong> ${book.author}</p>
  <p><strong>Description:</strong> ${book.description}</p>
  <p><strong>File:</strong> <a href="library-books/${book.file}" target="_blank">${book.file}</a></p>
</c:if>
</body>
</html>
