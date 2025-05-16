<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/15/2025
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Now Showing</h2>
<ul>
    <c:forEach var="movie" items="${movies}">
        <li>
            <strong>${movie.title}</strong> - Directed by ${movie.director} - Genre: ${movie.genre}
            <a href="/detailMovie?id=${movie.id}">View Details</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
