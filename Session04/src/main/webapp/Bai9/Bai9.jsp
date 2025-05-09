<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/9/2025
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*, javax.servlet.*" %>
<%@ page import="com.data.session04.Ghe" %>

<%
    String[] gheChon = request.getParameterValues("gheChon");
    List<String> chonList = (gheChon != null) ? Arrays.asList(gheChon) : new ArrayList<>();
    int tongTien = 0;

    List<Ghe> gheDaDat = (List<Ghe>) request.getAttribute("danhSachGhe");
    if (gheDaDat == null) {
        gheDaDat = (List<Ghe>) application.getAttribute("danhSachGhe");
    }

    if (chonList.isEmpty()) {
%>
<p style="color:red;">Bạn chưa chọn ghế nào! Vui lòng chọn trước khi thanh toán.</p>
<%
} else {
%>
<h3>Thông tin thanh toán:</h3>
<ul>
    <%
        for (Ghe g : gheDaDat) {
            if (chonList.contains(g.getMaGhe())) {
                tongTien += g.getGia();
    %>
    <li><%= g.getTenGhe() %> - <%= g.getGia() %> VND</li>
    <%
            }
        }
    %>
</ul>
<p><strong>Tổng tiền: <%= tongTien %> VND</strong></p>
<%
    }
%>

