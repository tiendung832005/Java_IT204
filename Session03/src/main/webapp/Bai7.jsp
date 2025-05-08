<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.data.session03.OrderCalculator" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/7/2025
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thông tin đơn hàng</h2>
<form method="post">
    <table>
        <tr>
            <th>Sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá mỗi sản phẩm</th>
        </tr>
        <% for (int i = 0; i < 3; i++) { %>
        <tr>
            <td><input type="text" name="product"></td>
            <td><input type="number" name="quantity" required></td>
            <td><input type="number" step="0.01" name="price" required></td>
        </tr>
        <% } %>
    </table>
    <br>
    <button type="submit">Tính tổng</button>
</form>

<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String[] quantities = request.getParameterValues("quantity");
        String[] prices = request.getParameterValues("price");

        if (quantities != null && prices != null) {
            List<String> qtyList = Arrays.asList(quantities);
            List<String> priceList = Arrays.asList(prices);

            double total = OrderCalculator.calculateTotal(qtyList, priceList);
%>
<h3>Tổng giá trị đơn hàng: <%= total %> VNĐ</h3>
<%
        }
    }
%>
</body>
</html>
