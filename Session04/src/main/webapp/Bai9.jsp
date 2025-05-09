<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/9/2025
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
    class Ghe {
        String maGhe, tenGhe;
        int gia;
        boolean daDat;

        Ghe(String ma, String ten, int g, boolean d) {
            maGhe = ma; tenGhe = ten; gia = g; daDat = d;
        }
    }

    List<Ghe> danhSachGhe = new ArrayList<>();
    danhSachGhe.add(new Ghe("A1", "Ghế A1", 50000, false));
    danhSachGhe.add(new Ghe("A2", "Ghế A2", 50000, true));
    danhSachGhe.add(new Ghe("B1", "Ghế B1", 60000, false));
    danhSachGhe.add(new Ghe("B2", "Ghế B2", 60000, false));
    request.setAttribute("danhSachGhe", danhSachGhe);

    String[] gheChon = request.getParameterValues("gheChon");
    request.setAttribute("gheChon", gheChon);
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Đặt Vé Xem Phim</title>
</head>
<body>

<h2>Chọn Ghế</h2>
<form method="post">
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Chọn</th><th>Mã Ghế</th><th>Tên Ghế</th><th>Giá</th><th>Trạng Thái</th>
        </tr>
        <c:forEach var="ghe" items="${danhSachGhe}">
            <tr>
                <td>
                    <c:if test="${!ghe.daDat}">
                        <input type="checkbox" name="gheChon" value="${ghe.maGhe}"
                               <c:if test="${fn:contains(fn:join(gheChon, ','), ghe.maGhe)}">checked</c:if> />
                    </c:if>
                </td>
                <td>${ghe.maGhe}</td>
                <td>${ghe.tenGhe}</td>
                <td>${ghe.gia}</td>
                <td>
                    <c:choose>
                        <c:when test="${ghe.daDat}">Đã đặt</c:when>
                        <c:otherwise>Trống</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <button type="submit">Thanh Toán</button>
</form>

<%-- Xử lý hiển thị thanh toán --%>
<c:if test="${not empty param.gheChon}">
    <h3>Kết Quả Thanh Toán</h3>
    <ul>
    <%
        int tongTien = 0;
        String[] gheChonList = request.getParameterValues("gheChon");
        if (gheChonList != null) {
            Set<String> selected = new HashSet<>(Arrays.asList(gheChonList));
            for (Ghe ghe : danhSachGhe) {
                if (selected.contains(ghe.maGhe)) {
                    tongTien += ghe.gia;
    %>
    <li><%= ghe.tenGhe %> - <%= ghe.gia %> VND</li>
    <%
            }
        }
    %>
    </ul>
    <strong>Tổng tiền: <%= tongTien %> VND</strong>
    <%
            }
        } else if (request.getMethod().equalsIgnoreCase("POST")) {
    %>
    <p style="color:red;">Vui lòng chọn ghế trước khi thanh toán!</p>
    <%
        }
    %>
    </body>
    </html>
