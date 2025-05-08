<%@ page import="com.data.session03.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/7/2025
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <h2>Thêm sản phẩm</h2>
      <form action="">
        ID: <input type="text" name="id" required/><br/>
        Tên: <input type="text" name="name" required/><br/>
        Giá: <input type="text" name="price" required/><br/>
        Mô tả: <input type="text" name="description" required/><br/>
        Số lượng: <input type="text" name="quantity" required/><br/>
      </form>
      <%
          ServletContext context = config.getServletContext();

          List<Product> productList = (List<Product>) context.getAttribute("products");
          if (productList == null) {
              productList = new ArrayList<>();
          }

          // Nếu là POST, thêm sản phẩm
          if ("POST".equalsIgnoreCase(request.getMethod())) {
              try {
                  int id = Integer.parseInt(request.getParameter("id"));
                  String name = request.getParameter("name");
                  double price = Double.parseDouble(request.getParameter("price"));
                  String desc = request.getParameter("desc");
                  int stock = Integer.parseInt(request.getParameter("stock"));
                  String status = request.getParameter("status");

                  Product newProduct = new Product(id, name, price, desc, stock, status);
                  productList.add(newProduct);
                  context.setAttribute("products", productList); // Lưu lại vào context
              } catch (Exception e) {
                  System.out.println("<p style='color:red;'>Dữ liệu không hợp lệ!</p>");
              }
          }
      %>

      <h3>Danh sách sản phẩm:</h3>
      <table>
          <tr>
              <th>ID</th>
              <th>Tên</th>
              <th>Giá</th>
              <th>Mô tả</th>
              <th>Tồn kho</th>
              <th>Trạng thái</th>
          </tr>
          <%
              for (Product p : productList) {
          %>
          <tr>
              <td><%= p.getId() %></td>
              <td><%= p.getProductName() %></td>
              <td><%= p.getPrice() %></td>
              <td><%= p.getDescription() %></td>
              <td><%= p.getStock() %></td>
              <td><%= p.getStatus() %></td>
          </tr>
          <%
              }
          %>
      </table>
</body>
</html>
