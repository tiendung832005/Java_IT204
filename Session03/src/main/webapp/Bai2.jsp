<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/7/2025
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Thông tin</h2>
    <form action="">
        Họ và tên: <input type="text" name="name"/><br/>
        Email: <input type="text" name="email"/><br/>
    </form>

<%
    ServletContext context = config.getServletContext();

    String name = request.getParameter("name");
    String email = request.getParameter("email");
    if(name != null && email != null) {
        context.setAttribute("userName", name);
        context.setAttribute("userEmail", email);
    }

    String saveName = (String) context.getAttribute("userName");
    String saveEmail = (String) context.getAttribute("userEmail");
%>
</body>
</html>
