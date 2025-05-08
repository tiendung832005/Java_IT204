<%@ page import="com.data.session03.Bai8.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/7/2025
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm Sách</h2>
<form action="books" method="post">
  <input type="hidden" name="action" value="add">
  Tên sách: <input type="text" name="title" required><br>
  Tác giả: <input type="text" name="author" required><br>
  Năm xuất bản: <input type="number" name="year" required><br>
  <button type="submit">Thêm sách</button>
</form>

<hr>

<h2>Tìm kiếm sách</h2>
<form action="books" method="post">
  <input type="hidden" name="action" value="search">
  Nhập tên sách: <input type="text" name="searchTerm" required>
  <button type="submit">Tìm</button>
</form>

<%
  List<Book> bookList = (List<Book>) application.getAttribute("bookList");
  List<Book> results = (List<Book>) request.getAttribute("searchResults");

  if (results != null) {
%>
<h3>Kết quả tìm kiếm:</h3>
<ul>
  <% for (Book b : results) { %>
  <li><b><%= b.getTitle() %></b> - <%= b.getAuthor() %> (<%= b.getYear() %>)</li>
  <% } %>
</ul>
<% } else if (bookList != null && !bookList.isEmpty()) { %>
<h3>Danh sách sách:</h3>
<ul>
  <% for (Book b : bookList) { %>
  <li><b><%= b.getTitle() %></b> - <%= b.getAuthor() %> (<%= b.getYear() %>)</li>
  <% } %>
</ul>
<% } %>
</body>
</html>
