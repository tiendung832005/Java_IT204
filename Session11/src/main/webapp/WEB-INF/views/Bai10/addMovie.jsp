<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/22/2025
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Thêm/Chỉnh sửa phim</title>
</head>
<body>
<h4>${movie.id == null ? "Thêm Phim" : "Chỉnh Sửa Phim"}</h4>
<%--@elvariable id="movie" type="java"--%>
<form:form modelAttribute="movie" action="${movie.id == null ? '/movies/add' : '/movies/edit/' + movie.id}" method="post" enctype="multipart/form-data">
    <div>
        <label for="title">Tiêu đề:</label>
        <form:input path="title" />
        <form:errors path="title" cssStyle="color: red;" />
    </div>
    <div>
        <label for="director">Đạo diễn:</label>
        <form:input path="director" />
        <form:errors path="director" cssStyle="color: red;" />
    </div>
    <div>
        <label for="releaseDate">Ngày phát hành:</label>
        <form:input path="releaseDate" type="date" />
        <form:errors path="releaseDate" cssStyle="color: red;" />
    </div>
    <div>
        <label for="genre">Thể loại:</label>
        <form:input path="genre" />
        <form:errors path="genre" cssStyle="color: red;" />
    </div>
    <div>
        <%--@declare id="posterfile"--%><label for="posterFile">Áp phích:</label>
        <input type="file" name="posterFile" />
    </div>
    <div>
        <input type="submit" value="${movie.id == null ? 'Thêm' : 'Cập nhật'}" />
    </div>
</form:form>
</body>
</html>