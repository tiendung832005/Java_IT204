<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/30/2025
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Danh Sách CV</title>
</head>
<body>
<div class="container mt-5">
    <h2>Danh Sách CV</h2>
    <a href="/resumes/new" class="btn btn-success mb-3">Thêm CV</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên đầy đủ</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Học vấn</th>
            <th>Kinh nghiệm</th>
            <th>Kỹ năng</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="resume : ${resumes}">
            <td th:text="${resume.id}"></td>
            <td th:text="${resume.fullName}"></td>
            <td th:text="${resume.email}"></td>
            <td th:text="${resume.phoneNumber}"></td>
            <td th:text="${resume.education}"></td>
            <td th:text="${resume.experience}"></td>
            <td th:text="${resume.skills}"></td>
            <td>
                <a th:href="@{/resumes/edit/{id}(id=${resume.id})}" class="btn btn-primary">Sửa</a>
                <a th:href="@{/resumes/delete/{id}(id=${resume.id})}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
