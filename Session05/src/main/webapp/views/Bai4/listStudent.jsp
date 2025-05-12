<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.data.session05.model.Student1" %>
<%
    List<Student1> students = (List<Student1>) request.getAttribute("students");
    int currentPage = (Integer) request.getAttribute("currentPage");
    int totalPages = (Integer) request.getAttribute("totalPages");
%>
<html>
<head>
    <title>Danh sách sinh viên</title>
    <style>
        table { border-collapse: collapse; width: 60%; margin: auto; }
        th, td { padding: 10px; text-align: center; border: 1px solid #ccc; }
        .pagination { text-align: center; margin-top: 20px; }
        .pagination a, .pagination span { margin: 0 5px; text-decoration: none; }
        .pagination span.current { font-weight: bold; color: blue; }
    </style>
    <script>
        function confirmDelete(id) {
            if (confirm("Bạn có chắc chắn muốn xóa sinh viên này không?")) {
                window.location.href = "deleteStudent?id=" + id;
            }
        }
    </script>
</head>
<body>
<h2 style="text-align:center;">Danh sách sinh viên</h2>
<table>
    <tr>
        <th>ID</th><th>Tên</th><th>Tuổi</th><th>Địa chỉ</th><th>Hành động</th>
    </tr>
    <% for (Student1 s : students) { %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getAge() %></td>
        <td><%= s.getAddress() %></td>
        <td>
            <form action="editStudent" method="get" style="display:inline;">
                <input type="hidden" name="id" value="<%= s.getId() %>">
                <input type="submit" value="Sửa">
            </form>
            <button onclick="confirmDelete(<%= s.getId() %>)">Xóa</button>
        </td>
    </tr>
    <% } %>
</table>

<div class="pagination">
    <%
        if (currentPage > 1) {
    %>
    <a href="studentList?page=<%= currentPage - 1 %>">Trước</a>
    <%
        }
    %>
    <span class="current">Trang <%= currentPage %> / <%= totalPages %></span>
    <%
        if (currentPage < totalPages) {
    %>
    <a href="studentList?page=<%= currentPage + 1 %>">Tiếp</a>
    <%
        }
    %>
</div>
</body>
</html>
