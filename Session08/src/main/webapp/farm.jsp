<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/15/2025
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Farm</title>
</head>
<body>
<h2>Farm</h2>
<p>${message}</p>
<div style="display: grid; grid-template-columns: repeat(5, 1fr); gap: 10px;">
  <c:forEach var="plot" items="${farm}">
    <div style="border: 1px solid black; padding: 10px; text-align: center;">
      <c:choose>
        <c:when test="${plot.seed != null}">
          <img src="${plot.seed.imageUrl}" alt="${plot.seed.seedsName}" style="max-width: 100px;"><br>
          <p>${plot.seed.seedsName}</p>
        </c:when>
        <c:otherwise>
          <form action="/plant" method="post">
            <input type="hidden" name="plotId" value="${plot.id}" />
            <label for="seed_${plot.id}">Select Seed:</label>
            <select name="seedId" id="seed_${plot.id}">
              <c:forEach var="ws" items="${warehouse}">
                <option value="${ws.seeds.id}">${ws.seeds.seedsName} (${ws.quantity})</option>
              </c:forEach>
            </select><br><br>
            <button type="submit">Plant</button>
          </form>
        </c:otherwise>
      </c:choose>
    </div>
  </c:forEach>
</div>
</body>
</html>
