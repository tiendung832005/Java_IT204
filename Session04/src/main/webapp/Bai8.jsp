<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/8/2025
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Doanh thu theo tháng</title>
</head>
<body>
<h2>Danh Sách Doanh Thu Theo Tháng</h2>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Tháng</th>
        <th>Doanh thu</th>
    </tr>

    <c:set var="total" value="0" scope="page"/>

    <c:forEach var="item" items="${applicationScope.revenueList}">
        <tr>
            <td>${item.month}</td>
            <td>${item.revenue}</td>
        </tr>
        <c:set var="total" value="${total + item.revenue}" scope="page"/>
    </c:forEach>
</table>

<h3>Tổng doanh thu: ${total}</h3>
<c:choose>
    <c:when test="${total > 10000}">
        <p style="color:green;"><strong>Tổng doanh thu lớn hơn 10,000.</strong></p>
    </c:when>
    <c:otherwise>
        <p style="color:red;"><strong>Tổng doanh thu không lớn hơn 10,000.</strong></p>
    </c:otherwise>
</c:choose>

</body>
</html>

