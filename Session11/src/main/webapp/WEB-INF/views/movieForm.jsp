<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/19/2025
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" tagdir=""%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Movie Form</h4>
<form form modelAttribute="movieDTO" action="/movie-save" method="post">
    <div>
        <%--@declare id="title"--%><label for="title">Title:</label>
        <form: input path="title" />
        <br>
        <form: errors path="title" cssStyle="color: red;" />
    </div>
    <div>
        <%--@declare id="email"--%><label for="email">Email:</label>
        <form: input path="email" />
        <br>
        <form: errors path="email" cssStyle="color: red;" />
    </div>
    <div>
        <%--@declare id="quantity"--%><label for="quantity">Quantity:</label>
        <form: input path="quantity" type="number" />
        <br>
        <form: errors path="quantity" cssStyle="color: red;" />
    </div>
    <div>
        <%--@declare id="birthday"--%><label for="birthday">Birthday:</label>
        <form: input path="birthday" type="date" />
        <br>
        <form: errors path="birthday" cssStyle="color: red;" />
    </div>
    <div>
        <%--@declare id="eventdate"--%><label for="eventDate">Event Date:</label>
        <form: input path="eventDate" type="date" />
        <br>
        <form: errors path="eventDate" cssStyle="color: red;" />
    </div>
    <div>
        <input type="submit" value="Submit" />
    </div>
</form>
</body>
</html>
