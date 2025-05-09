<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/8/2025
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>
<h2>Danh Sách Sinh Viên</h2>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Điểm Trung Bình</th>
    </tr>

    <c:set var="count" value="0" />
    <c:forEach var="sv" items="${students}">
        <tr>
            <td>${sv.id}</td>
            <td>${sv.name}</td>
            <td>${sv.age}</td>
            <td>${sv.gpa}</td>
        </tr>
        <c:if test="${sv.gpa > 7.0}">
            <c:set var="count" value="${count + 1}" />
        </c:if>
    </c:forEach>
</table>

<p><strong>Số sinh viên có điểm trung bình &gt; 7.0:</strong> ${count}</p>
</body>
</html>
