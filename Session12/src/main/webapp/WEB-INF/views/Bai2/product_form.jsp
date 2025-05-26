<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/25/2025
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
  <title>Thêm/Sửa sản phẩm</title>
</head>
<body>
<h2>Thêm/Sửa sản phẩm</h2>
<form action="" method="post">
  Tên: <input type="text" name="name" value="${product.name}" required><br>
  Giá: <input type="number" name="price" value="${product.price}" step="0.01" required><br>
  Số lượng: <input type="number" name="quantity" value="${product.quantity}" required><br>
  Hình ảnh: <input type="text" name="image" value="${product.image}"><br>
  <button type="submit">Lưu</button>
</form>
</body>
</html>
