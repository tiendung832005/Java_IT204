<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/12/2025
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Edit Book</title>
</head>
<body>
<h1>Edit Book</h1>
<form action="books?action=update" method="post">
  <input type="hidden" name="bookCode" value="${book.bookCode}"/>
  <label>Title:</label>
  <input type="text" name="title" value="${book.title}" required/><br/>
  <label>Author:</label>
  <input type="text" name="author" value="${book.author}" required/><br/>
  <label>Genre:</label>
  <input type="text" name="genre" value="${book.genre}"/><br/>
  <label>Quantity:</label>
  <input type="number" name="quantity" value="${book.quantity}" required/><br/>
  <button type="submit">Update</button>
</form>
</body>
</html>
