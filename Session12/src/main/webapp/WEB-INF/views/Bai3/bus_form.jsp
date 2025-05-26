<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/25/2025
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Thêm/Sửa xe khách</title>
</head>
<body>
<h2>Thêm/Sửa xe khách</h2>
<form action="" method="post">
    Biển số: <input type="text" name="licensePlate" value="${bus.licensePlate}" required><br>
    Loại xe:
    <select name="busType" required>
        <option value="NORMAL" ${bus.busType == 'NORMAL' ? 'selected' : ''}>NORMAL</option>
        <option value="VIP" ${bus.busType == 'VIP' ? 'selected' : ''}>VIP</option>
        <option value="LUXURY" ${bus.busType == 'LUXURY' ? 'selected' : ''}>LUXURY</option>
    </select><br>
    Số hàng ghế: <input type="number" name="rowSeat" value="${bus.rowSeat}" required><br>
    Số cột ghế: <input type="number" name="colSeat" value="${bus.colSeat}" required><br>
    Hình ảnh: <input type="text" name="image" value="${bus.image}"><br>
    <button type="submit">Lưu</button>
</form>
</body>
</html>
