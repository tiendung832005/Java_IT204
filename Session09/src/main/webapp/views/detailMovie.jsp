<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/15/2025
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Movie Details</title>
</head>
<body>
<h2>${movie.title}</h2>
<p><strong>Director:</strong> ${movie.director}</p>
<p><strong>Genre:</strong> ${movie.genre}</p>
<p><strong>Description:</strong> ${movie.description}</p>
<p><strong>Duration:</strong> ${movie.duration} minutes</p>
<p><strong>Language:</strong> ${movie.language}</p>

<h3>Showtimes</h3>
<ul>
    <c:forEach var="schedule" items="${schedules}">
        <li>
            <strong>Showtime:</strong> ${schedule.showTime} -
            <strong>Format:</strong> ${schedule.format} -
            <strong>Available Seats:</strong> ${schedule.availableSeats}
        </li>
    </c:forEach>
</ul>

<a href="/">Back to Home</a>
</body>
</html>
