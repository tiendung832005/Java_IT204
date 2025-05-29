<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/29/2025
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <title><fmt:message key="title" /></title>
</head>
<body>
<h1><fmt:message key="title" /></h1>

<form action="/categories/add" method="post">
  <label for="categoryNameVi"><fmt: message key="label.categoryNameVi" /></label>
  <input type="text" id="categoryNameVi" name="categoryNameVi" required><br>
  <label for="descriptionVi"><fmt: message key="label.descriptionVi" /></label>
  <input type="text" id="descriptionVi" name="descriptionVi" required><br>
  <label for="categoryNameEn"><fmt: message key="label.categoryNameEn" /></label>
  <input type="text" id="categoryNameEn" name="categoryNameEn" required><br>
  <label for="descriptionEn"><fmt: message key="label.descriptionEn" /></label>
  <input type="text" id="descriptionEn" name="descriptionEn" required><br>
  <button type="submit"><fmt: message key="button.submit" /></button>
</form>

<form action="/change-language" method="get">
  <label for="lang">Language:</label>
  <select id="lang" name="lang">
    <option value="en">English</option>
    <option value="vi">Tiếng Việt</option>
  </select>
  <button type="submit">Change Language</button>
</form>
</body>
</html>