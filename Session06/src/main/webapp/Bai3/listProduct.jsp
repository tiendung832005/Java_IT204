<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/12/2025
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><img src="${product.imageUrl}" alt="Product Image" width="100"/></td>
            <td>
                <form action="products" method="post">
                    <input type="hidden" name="userId" value="1"/>
                    <input type="hidden" name="productId" value="${product.id}"/>
                    <input type="number" name="quantity" value="1" min="1"/>
                    <button type="submit">Add to Cart</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
