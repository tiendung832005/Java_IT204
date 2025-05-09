<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/8/2025
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Tìm kiếm sản phẩm</title>
</head>
<body>
<h2>Tìm kiếm sản phẩm theo ID</h2>
<form action="search" method="post">
    Nhập ID sản phẩm: <input type="text" name="productId" />
    <input type="submit" value="Tìm kiếm" />
</form>

<hr/>

<c:choose>
    <c:when test="${not empty product}">
        <h3>Thông tin sản phẩm:</h3>
        <p><strong>ID:</strong> ${product.id}</p>
        <p><strong>Tên:</strong> ${product.productName}</p>
        <p><strong>Giá:</strong> ${product.price}</p>
        <p><strong>Mô tả:</strong> ${product.description}</p>
    </c:when>
    <c:otherwise>
        <c:if test="${not empty param.productId}">
            <p style="color:red;">Sản phẩm không tìm thấy.</p>
        </c:if>
    </c:otherwise>
</c:choose>
</body>
</html>

