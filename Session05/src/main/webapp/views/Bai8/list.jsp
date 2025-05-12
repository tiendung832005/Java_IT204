<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 6/11/2025
  Time: 00:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách công việc</title></head>
<body>
<h2>Danh sách Tasks</h2>
<a href="tasks?action=add">Thêm task mới</a>
<table border="1" cellpadding="10">
    <tr>
        <th>ID</th><th>Mô tả</th><th>Ngày đến hạn</th><th>Hoàn thành</th><th>Hành động</th>
    </tr>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.description}</td>
            <td>${task.dueDate}</td>
            <td><c:if test="${task.completed}">✔</c:if></td>
            <td>
                <a href="tasks?action=edit&id=${task.id}">Sửa</a>
                <form action="tasks?action=delete" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${task.id}" />
                    <input type="submit" value="Xóa" />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

