<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/21/2025
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<tr>
  <td>${category.id}</td>
  <td>${category.categoryName}</td>
  <td>${category.status ? "Hoạt động" : "Không hoạt động"}</td>
  <td>
    <a href="/categories/edit/${category.id}">Chỉnh sửa</a> |
    <a href="/categories/delete/${category.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa danh mục này?');">Xóa</a>
  </td>
</tr>
