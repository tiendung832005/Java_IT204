<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/20/2025
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Đánh giá sản phẩm</title>
</head>
<body>
<h4>Form Đánh Giá Sản Phẩm</h4>
<form:form modelAttribute="productReviewDTO" action="/review" method="post">
  <div>
    <label for="name">Tên:</label>
    <form:input path="name" />
    <br>
    <form:errors path="name" cssStyle="color: red;" />
  </div>
  <div>
    <label for="email">Email:</label>
    <form:input path="email" />
    <br>
    <form:errors path="email" cssStyle="color: red;" />
  </div>
  <div>
    <label for="rating">Đánh giá (1-5):</label>
    <form:input path="rating" type="number" />
    <br>
    <form:errors path="rating" cssStyle="color: red;" />
  </div>
  <div>
    <label for="comment">Bình luận:</label>
    <form:textarea path="comment" />
    <br>
    <form:errors path="comment" cssStyle="color: red;" />
  </div>
  <div>
    <input type="submit" value="Gửi đánh giá" />
  </div>
</form:form>
</body>
</html>
