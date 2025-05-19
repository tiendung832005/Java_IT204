<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/17/2025
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Document Upload Result</title>
</head>
<body>
<h1>Document Upload Result</h1>
<p>${message}</p>
<c:if test="${not empty document}">
  <p><strong>Title:</strong> ${document.title}</p>
  <p><strong>Description:</strong> ${document.description}</p>
  <p><strong>File:</strong> <a href="documents/${document.file}" target="_blank">${document.file}</a></p>
</c:if>
</body>
</html>
