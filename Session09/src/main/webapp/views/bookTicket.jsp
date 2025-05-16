<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/15/2025
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- bookTicket.jsp -->
<!DOCTYPE html>
<html>
<head>
  <title>Book Ticket</title>
</head>
<body>
<h2>Book Ticket</h2>
<form action="/confirmBooking" method="post">
  <input type="hidden" name="scheduleId" value="${scheduleId}">
  <h3>Available Seats</h3>
  <ul>
    <c:forEach var="seat" items="${seats}">
      <c:if test="${seat.status == 'Available'}">
        <li>
          <input type="checkbox" name="selectedSeats" value="${seat.id}">
          Seat ${seat.id}
        </li>
      </c:if>
    </c:forEach>
  </ul>
  <button type="submit">Confirm Booking</button>
</form>
</body>
</html>
