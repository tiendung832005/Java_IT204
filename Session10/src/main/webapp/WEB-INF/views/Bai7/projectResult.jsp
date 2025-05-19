<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/17/2025
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Project Result</title>
</head>
<body>
<h1>Project Result</h1>
<p>${message}</p>
<c:if test="${not empty project}">
  <p><strong>Project Name:</strong> ${project.name}</p>
  <p><strong>Description:</strong> ${project.description}</p>
  <h3>Documents:</h3>
  <ul>
    <c:forEach var="doc" items="${project.documents}">
      <li><a href="${doc.file}" target="_blank">${doc.fileName}</a></li>
    </c:forEach>
  </ul>
</c:if>
</body>
</html>
