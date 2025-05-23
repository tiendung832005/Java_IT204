<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/21/2025
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Chỉnh sửa danh mục</title>
</head>
<body>
<h4>Chỉnh Sửa Danh Mục</h4>
<%--@elvariable id="category" type="java"--%>
<form:form modelAttribute="category" action="/categories/edit/${category.id}" method="post">
  <div>
    <label for="categoryName">Tên danh mục:</label>
    <form:input path="categoryName" />
    <br>
    <form:errors path="categoryName" cssStyle="color: red;" />
  </div>
  <div>
    <input type="submit" value="Cập nhật" />
  </div>
</form:form>
</body>
</html>
