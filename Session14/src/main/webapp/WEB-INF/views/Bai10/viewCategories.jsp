<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/29/2025
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>View Categories</title>
</head>
<body>
<h1>Categories</h1>
<ul>
  <c: forEach var="category" items="${categories}">
    <li>${category.categoryName} - ${category.description}</li>
  </c>
</ul>
<a href="/categories">Add New Category</a>
</body>
</html>
