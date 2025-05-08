package com.data.session02;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RegisterServlet ", value = "/RegisterServlet ")
public class RegisterServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        request.getSession().setAttribute("registeredName", name);
        request.getSession().setAttribute("registeredEmail", email);

        response.sendRedirect("thankyou.jsp");
    }

    public void destroy() {
    }
}
