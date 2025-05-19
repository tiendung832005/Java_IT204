<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/18/2025
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Booking Result</title>
</head>
<body>
<h1>Booking Result</h1>
<p>${message}</p>
<c:if test="${not empty ticket}">
  <p><strong>Movie Title:</strong> ${ticket.movieTitle}</p>
  <p><strong>Show Time:</strong> ${ticket.showTime}</p>
  <p><strong>Seats:</strong>
  <ul>
    <c:forEach var="seat" items="${ticket.seats}">
      <li>${seat.seatNumber}</li>
    </c:forEach>
  </ul>
  </p>
  <p><strong>Total Amount:</strong> ${ticket.totalAmount}</p>
</c:if>
</body>
</html>
