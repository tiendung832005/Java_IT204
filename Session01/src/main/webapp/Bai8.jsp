<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/6/2025
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        .navbar {
            background-color: #6464e2;
            padding: 10px;
            margin-bottom: 20px;
            text-align: center;
        }

        .navbar a {
            color: white;
            padding: 0 20px;
            text-decoration: none;
        }

        .add-form {
            margin-bottom: 20px;
            display: flex;
        }

        .add-form input[type="text"] {
            flex-grow: 1;
            padding: 10px;
            margin-right: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .add-form button {
            padding: 10px 20px;
            background-color: #6464e2;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(odd) {
            background-color: #6464e2;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #ffff00;
        }

        .status-button {
            padding: 5px 10px;
            background-color: transparent;
            border: none;
            color: blue;
            text-decoration: underline;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="navbar">
    <a href="#">Trang chủ</a>
    <a href="#">Liên hệ</a>
    <a href="#">Giỏ hàng</a>
    <a href="#">Tài khoản</a>
</div>

<form class="add-form" action="${pageContext.request.contextPath}/tasks" method="post">
    <input type="hidden" name="action" value="add">
    <input type="text" name="jobName" placeholder="Enter new job" required>
    <button type="submit">Add</button>
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Job Name</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.jobName}</td>
            <td>${task.status}</td>
            <td>
                <form action="${pageContext.request.contextPath}/tasks" method="post">
                    <input type="hidden" name="action" value="changeStatus">
                    <input type="hidden" name="id" value="${task.id}">
                    <input type="hidden" name="currentStatus" value="${task.status}">
                    <button type="submit" class="status-button">Change status</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
