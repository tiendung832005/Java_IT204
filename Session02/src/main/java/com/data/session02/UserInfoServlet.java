package com.data.session02;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UserInfoServlet", value = "/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        request.setAttribute("userName", name);
        request.setAttribute("userAge", age);

        request.getRequestDispatcher("/Bai2.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
