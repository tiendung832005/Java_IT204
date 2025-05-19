<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/17/2025
  Time: 8:39 PM
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
<c:if test="${not empty userProfile}">
  <p><strong>Username:</strong> ${userProfile.username}</p>
  <p><strong>Avatar:</strong> <img src="uploads/${userProfile.avatar}" alt="Avatar" width="100"></p>
</c:if>
</body>
</html>
