<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/28/2025
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <title><fmt: message key="title.registration" /></title>
</head>
<body>
<h1><fmt: message key="title.registration" /></h1>

<form action="/register" method="post">
  <label for="username"><fmt: message key="label.username" /></label>
  <input type="text" id="username" name="username" required><br>
  <label for="password"><fmt: message key="label.password" /></label>
  <input type="password" id="password" name="password" required><br>
  <label for="confirmPassword"><fmt: message key="label.confirmPassword" /></label>
  <input type="password" id="confirmPassword" name="confirmPassword" required><br>
  <label for="email"><fmt: message key="label.email" /></label>
  <input type="email" id="email" name="email" required><br>
  <button type="submit"><fmt: message key="button.register" /></button>
</form>

<p>${message}</p>

<form action="/change-language" method="get">
  <label for="lang"><fmt: message key="label.language" /></label>
  <select id="lang" name="lang">
    <option value="en">English</option>
    <option value="vi">Tiếng Việt</option>
  </select>
  <button type="submit"><fmt:message key="button.changeLanguage" /></button>
</form>
</body>
</html>
