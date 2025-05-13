<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/12/2025
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Book List</title>
</head>
<body>
<h1>Book List</h1>
<a href="books?action=add">Add New Book</a>
<table border="1">
  <thead>
  <tr>
    <th>Code</th>
    <th>Title</th>
    <th>Author</th>
    <th>Genre</th>
    <th>Quantity</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${books}">
    <tr>
      <td><c:out value="${book.bookCode}"/></td>
      <td><c:out value="${book.title}"/></td>
      <td><c:out value="${book.author}"/></td>
      <td><c:out value="${book.genre}"/></td>
      <td><c:out value="${book.quantity}"/></td>
      <td>
        <a href="books?action=edit&bookCode=${book.bookCode}">Edit</a>
        <a href="books?action=delete&bookCode=${book.bookCode}" onclick="return confirm('Are you sure?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>