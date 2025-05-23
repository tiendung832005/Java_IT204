<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/22/2025
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách phim</title>
</head>
<body>
<h4>Danh Sách Phim</h4>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Đạo diễn</th>
        <th>Ngày phát hành</th>
        <th>Thể loại</th>
        <th>Áp phích</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>${movie.id}</td>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.releaseDate}</td>
            <td>${movie.genre}</td>
            <td><img src="${movie.poster}" alt="Poster" width="100"></td>
            <td>
                <a href="/movies/edit/${movie.id}">Chỉnh sửa</a> |
                <a href="/movies/delete/${movie.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa phim này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/movies/add">Thêm phim mới</a>
</body>
</html>
