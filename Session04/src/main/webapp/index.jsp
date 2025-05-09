<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<h3>Trang chủ</h3>
<%--Dùng jstl core in ra 1 giá trị--%>
<c:out value="Pham Chien"></c:out>
<br/>
<a href="productList.jsp">Bài 1</a>
<br/>
<a href="Bai2.jsp">Bài 2</a>
<br/>
<a href="Bai3/main.jsp">Bài 3</a>
<br/>
<a href="Bai4.jsp">Bài 4</a>
<br/>
<a href="Bai5.jsp">Bài 5</a>
</body>
</html>