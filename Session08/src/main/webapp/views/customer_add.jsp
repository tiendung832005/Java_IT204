<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/15/2025
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h4>Add Customer</h4>

<form action="customer-save" method="post">
  <div>
    <label for="fullName">Full Name</label>
    <input type="text" name="fullName" id="fullName" />
  </div>
  <div>
    <label for="email">Email</label>
    <input type="text" name="email" id="email" />
  </div>

  <div>
    <input type="radio" name="gender" value="MALE"/> MALE
    <input type="radio" name="gender" value="FEMALE"> FEMALE
  </div>

  <div>
    <input type="radio" name="customerType" value="VIP"/> VIP
    <input type="radio" name="customerType" value="STANDARD"> STANDARD
  </div>
  <div>
    <input type="submit" value="Save" />
  </div>
</form>
</body>
</html>
