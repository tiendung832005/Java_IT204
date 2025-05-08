package com.data.session03.Bai9;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserManager userManager;
    private int currentId = 1;

    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
        getServletContext().setAttribute("userManager", userManager);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (name != null && email != null) {
            User user = new User(currentId++, name, email);
            userManager.addUser(user);
            request.setAttribute("message", "Đăng ký thành công!");
        }

        request.getRequestDispatcher("Bai9.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String idStr = request.getParameter("id");

        if ("delete".equals(action) && idStr != null) {
            int id = Integer.parseInt(idStr);
            userManager.removeUser(id);
        }

        request.getRequestDispatcher("Bai9.jsp").forward(request, response);
    }
}

