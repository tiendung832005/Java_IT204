<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 6/11/2025
  Time: 00:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Task Form</title></head>
<body>
<h2><c:if test="${task != null}">Chỉnh sửa</c:if><c:if test="${task == null}">Thêm</c:if> Task</h2>
<form action="tasks" method="post">
    <input type="hidden" name="action" value="${task != null ? 'update' : 'create'}" />
    <c:if test="${task != null}">
        <input type="hidden" name="id" value="${task.id}" />
    </c:if>
    Mô tả: <input type="text" name="description" value="${task.description}" required /><br/>
    Ngày đến hạn: <input type="text" name="dueDate" value="${task.dueDate}" required /><br/>
    Hoàn thành: <input type="checkbox" name="completed" <c:if test="${task.completed}">checked</c:if> /><br/>
    <input type="submit" value="Lưu" />
</form>
</body>
</html>

