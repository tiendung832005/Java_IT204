<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/29/2025
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- File: src/main/resources/templates/fragments/header.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title th:text="${title}">Default Title</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a th:href="@{/}">Home</a></li>
            <li><a th:href="@{/about}">About</a></li>
            <li><a th:href="@{/contact}">Contact</a></li>
        </ul>
    </nav>
</header>
