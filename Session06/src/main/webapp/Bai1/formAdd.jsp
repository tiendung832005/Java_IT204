<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/12/2025
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<h1>Add New Book</h1>
<form action="books?action=create" method="post">
    <label>Book Code:</label>
    <input type="text" name="bookCode" required/><br/>
    <label>Title:</label>
    <input type="text" name="title" required/><br/>
    <label>Author:</label>
    <input type="text" name="author" required/><br/>
    <label>Genre:</label>
    <input type="text" name="genre"/><br/>
    <label>Quantity:</label>
    <input type="number" name="quantity" required/><br/>
    <button type="submit">Save</button>
</form>
</body>
</html>
