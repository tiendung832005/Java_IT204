<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/20/2025
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm danh mục</title>
</head>
<body>
<h4>Thêm Danh Mục</h4>
<form:form modelAttribute="category" action="/categories/add" method="post">
    <div>
        <label for="categoryName">Tên danh mục:</label>
        <form:input path="categoryName" />
        <br>
        <form:errors path="categoryName" cssStyle="color: red;" />
    </div>
    <div>
        <input type="submit" value="Thêm" />
    </div>
</form:form>
</body>
</html>
