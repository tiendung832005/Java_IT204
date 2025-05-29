<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/28/2025
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Finance Management</title>
</head>
<body>
<h1>Finance Management</h1>

<h2>Add Transaction</h2>
<form action="/finance/add" method="post">
  <label for="description">Description:</label>
  <input type="text" id="description" name="description" required><br>
  <label for="amount">Amount:</label>
  <input type="number" id="amount" name="amount" required><br>
  <label for="type">Type:</label>
  <select id="type" name="type">
    <option value="income">Income</option>
    <option value="expense">Expense</option>
  </select><br>
  <button type="submit">Add Transaction</button>
</form>

<p style="color:green;">${message}</p>

<h2>Transactions</h2>
<ul>
  <c forEach var="transaction" items="${transactions}">
    <li>
        ${transaction.description} - ${transaction.amount} (${transaction.type})
      <a href="/finance/delete?description=${transaction.description}">Delete</a>
    </li>
  </c>
</ul>

<form action="/change-language" method="get">
  <label for="lang">Language:</label>
  <select id="lang" name="lang">
    <option value="en">English</option>
    <option value="vi">Tiếng Việt</option>
  </select>
  <button type="submit">Change Language</button>
</form>
</body>
</html>
