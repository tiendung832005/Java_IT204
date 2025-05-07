<%@ page import="com.data.session02.Bai9.GameState" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/6/2025
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    GameState game = (GameState) request.getAttribute("game");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Game Đoán Từ</h2>

<p>Từ bí mật: <strong><%= game.getDisplayWord() %></strong></p>
<p>Số lần đoán sai còn lại: <%= game.getRemainingTries() %></p>

<% if (game.isGameOver()) { %>
<h3 style="color:<%= game.isWin() ? "green" : "red" %>">
    <%= game.isWin() ? "Bạn đã thắng!" : "Bạn đã thua. Từ đúng là: " + game.getSecretWord() %>
</h3>
<a href="guess?restart=true">Chơi lại</a>
<% } else { %>
<form method="post" action="guess">
    Nhập từ bạn đoán: <input type="text" name="guess" required>
    <input type="submit" value="Đoán">
</form>
<% } %>
</body>
</html>
