<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/11/2025
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
  <h1>Nhập Thông Tin Sinh Viên</h1>

  <c:if test="${not empty error}">
    <div class="error-message">
      <c:out value="${error}" />
    </div>
  </c:if>

  <form action="${pageContext.request.contextPath}/student" method="post">
    <div class="form-group">
      <label for="name">Họ và tên:</label>
      <input type="text" id="name" name="name" required>
    </div>

    <div class="form-group">
      <label for="age">Tuổi:</label>
      <input type="number" id="age" name="age" min="1" required>
    </div>

    <div class="form-group">
      <label for="address">Địa chỉ:</label>
      <input type="text" id="address" name="address" required>
    </div>

    <div class="form-group">
      <button type="submit" class="btn-submit">Gửi Thông Tin</button>
    </div>
  </form>
</div>
</body>
</html>
