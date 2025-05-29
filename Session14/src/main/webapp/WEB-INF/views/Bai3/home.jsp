<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/28/2025
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title><fmt:message key="title" /></title>
</head>
<body>
<h1><fmt:message key="greeting" /></h1>
<form action="/change-language" method="get">
  <label for="lang"><fmt:message key="language" /></label>
  <select id="lang" name="lang">
    <option value="en">English</option>
    <option value="vi">Tiếng Việt</option>
  </select>
  <button type="submit">Change</button>
</form>
</body>
</html>
