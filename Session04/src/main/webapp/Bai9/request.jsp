<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/9/2025
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page import="com.data.session04.Ghe" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

    List<Ghe> danhSachGhe = new ArrayList<>();
    danhSachGhe.add(new Ghe("A1", "Ghế A1", 50000, false));
    danhSachGhe.add(new Ghe("A2", "Ghế A2", 50000, true));
    danhSachGhe.add(new Ghe("B1", "Ghế B1", 60000, false));

    request.setAttribute("danhSachGhe", danhSachGhe);
%>
<form action="thanhToan.jsp" method="post">
    <table border="1">
        <tr>
            <th>Chọn</th><th>Mã Ghế</th><th>Tên Ghế</th><th>Giá</th><th>Trạng Thái</th>
        </tr>
        <c:forEach var="ghe" items="${danhSachGhe}">
            <tr>
                <td>
                    <c:if test="${!ghe.daDat}">
                        <input type="checkbox" name="gheChon" value="${ghe.maGhe}" />
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
    <button type="submit">Thanh Toán</button>
</form>

