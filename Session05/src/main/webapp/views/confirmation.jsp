<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/11/2025
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
  <h1>Xác Nhận Thông Tin</h1>

  <div class="success-message">
    Thông tin sinh viên đã được gửi thành công!
  </div>

  <div class="student-info">
    <div class="info-item">
      <span class="label">Họ và tên:</span>
      <span class="value"><c:out value="${student.name}" /></span>
    </div>

    <div class="info-item">
      <span class="label">Tuổi:</span>
      <span class="value"><c:out value="${student.age}" /></span>
    </div>

    <div class="info-item">
      <span class="label">Địa chỉ:</span>
      <span class="value"><c:out value="${student.address}" /></span>
    </div>
  </div>

  <a href="${pageContext.request.contextPath}/student" class="btn-back">Nhập Thông Tin Mới</a>
</div>
</body>
</html>
