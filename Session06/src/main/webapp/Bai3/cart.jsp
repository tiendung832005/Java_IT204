<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/12/2025
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<h1>Your Cart</h1>
<table border="1">
    <thead>
    <tr>
        <th>Product</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Total</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Product Name</td>
        <td>2</td>
        <td>$10</td>
        <td>$20</td>
        <td>
            <form action="cart" method="post">
                <input type="hidden" name="cartId" value="1"/>
                <button type="submit">Remove</button>
            </form>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
