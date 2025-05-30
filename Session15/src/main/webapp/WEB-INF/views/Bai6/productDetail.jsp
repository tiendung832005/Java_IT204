<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/29/2025
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Product Detail</title>
</head>
<body>
<h1>Product Detail</h1>
<div>
  <p><strong>ID:</strong> <span th:text="${product.id}"></span></p>
  <p><strong>Name:</strong> <span th:text="${product.productName}"></span></p>
  <p><strong>Price:</strong> <span th:text="${product.price}"></span></p>
</div>

<h2>Reviews</h2>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>User ID</th>
    <th>Rating</th>
    <th>Comment</th>
  </tr>
  </thead>
  <tbody>
  <tr th:each="review : ${reviews}">
    <td th:text="${review.id}"></td>
    <td th:text="${review.idUser}"></td>
    <td th:text="${review.rating}"></td>
    <td th:text="${review.comment}"></td>
  </tr>
  </tbody>
</table>
<p th:if="${reviews.size() == 0}">No reviews available.</p>

<h2>Add Review</h2>
<form th:action="@{/add-review}" th:object="${newReview}" method="post">
  <input type="hidden" th:field="*{idProduct}" th:value="${product.id}" />
  <div>
    <label for="idUser">User ID:</label>
    <input type="text" id="idUser" th:field="*{idUser}" />
  </div>
  <div>
    <label for="rating">Rating:</label>
    <input type="number" id="rating" th:field="*{rating}" min="1" max="5" />
  </div>
  <div>
    <label for="comment">Comment:</label>
    <textarea id="comment" th:field="*{comment}"></textarea>
  </div>
  <button type="submit">Submit Review</button>
</form>
</body>
</html>
