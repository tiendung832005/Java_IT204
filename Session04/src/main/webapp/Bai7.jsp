<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/8/2025
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Lọc Sản Phẩm Theo Giá</title>
</head>
<body>
<h2>Lọc Sản Phẩm</h2>

<form action="products" method="get">
  Giá tối thiểu: <input type="text" name="min" />
  Giá tối đa: <input type="text" name="max" />
  <input type="submit" value="Lọc" />
</form>

<h3>Kết quả:</h3>

<c:choose>
  <c:when test="${not empty products}">
    <table border="1" cellpadding="5">
      <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Giá</th>
      </tr>
      <c:forEach var="p" items="${products}">
        <tr>
          <td>${p.id}</td>
          <td>${p.name}</td>
          <td>${p.price}</td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <c:if test="${filterApplied}">
      <p><strong>Không có sản phẩm nào trong khoảng giá này.</strong></p>
    </c:if>
  </c:otherwise>
</c:choose>
</body>
</html>

