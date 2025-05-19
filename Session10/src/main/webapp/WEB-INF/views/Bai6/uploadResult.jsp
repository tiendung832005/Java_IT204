<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/17/2025
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Upload Result</title>
</head>
<body>
<h1>Upload Result</h1>
<p>${message}</p>
<c:if test="${not empty uploadFile}">
  <p><strong>File Name:</strong> ${uploadFile.fileName}</p>
  <p><strong>Description:</strong> ${uploadFile.description}</p>
  <p><strong>Cloud URL:</strong> <a href="${uploadFile.cloudUrl}" target="_blank">${uploadFile.cloudUrl}</a></p>
</c:if>
</body>
</html>
