<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/25/2025
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Danh sách xe khách</title>
</head>
<body>
<h2>Danh sách xe khách</h2>
<a href="/buses/add">Thêm xe</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Biển số</th>
        <th>Loại xe</th>
        <th>Số hàng ghế</th>
        <th>Số cột ghế</th>
        <th>Tổng số ghế</th>
        <th>Hình ảnh</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="bus" items="${buses}">
        <tr>
            <td>${bus.id}</td>
            <td>${bus.licensePlate}</td>
            <td>${bus.busType}</td>
            <td>${bus.rowSeat}</td>
            <td>${bus.colSeat}</td>
            <td>${bus.totalSeat}</td>
            <td><img src="${bus.image}" alt="Image" width="50"></td>
            <td>
                <a href="/buses/delete/${bus.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
