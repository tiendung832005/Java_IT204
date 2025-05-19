<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/18/2025
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Ticket</title>
</head>
<body>
<h1>Book Ticket</h1>
<form action="bookTicket" method="post">
    <label for="movieTitle">Movie Title:</label>
    <input type="text" id="movieTitle" name="movieTitle" required><br><br>

    <label for="showTime">Show Time (yyyy-MM-dd HH:mm):</label>
    <input type="text" id="showTime" name="showTime" required><br><br>

    <label for="seats">Seats (comma-separated):</label>
    <input type="text" id="seats" name="seats" required><br><br>

    <label for="totalAmount">Total Amount:</label>
    <input type="number" id="totalAmount" name="totalAmount" step="0.01" required><br><br>

    <button type="submit">Book Ticket</button>
</form>
</body>
</html>
