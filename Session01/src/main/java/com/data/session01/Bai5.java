package com.data.session01;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bai5", value = "/Bai5")
public class Bai5 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            int result = 10/0;
            response.getWriter().println("Keets qua: " + result);
        }catch (Exception e){
            request.setAttribute("errorMessage", "Đã xảy ra lỗi trong quá trình xử lý: " + e.getMessage());
            request.getRequestDispatcher("/Bai5.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}
