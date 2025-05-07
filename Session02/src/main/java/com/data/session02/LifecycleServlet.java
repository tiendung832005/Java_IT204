package com.data.session02;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LifecycleServlet", value = "/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Servlet Lifecycle</title></head>");
        out.println("<body>");
        out.println("<h1>Servlet Lifecycle Stages</h1>");
        out.println("<ul>");
        out.println("<li><b>init()</b>: Được gọi một lần khi Servlet được khởi tạo lần đầu tiên.</li>");
        out.println("<li><b>service()</b>: Được gọi mỗi khi có request đến (ví dụ: người dùng truy cập vào URL).</li>");
        out.println("<li><b>destroy()</b>: Được gọi một lần khi Servlet bị loại bỏ khỏi bộ nhớ.</li>");
        out.println("</ul>");
        out.println("<p>Trang này được tạo bởi phương thức <code>doGet()</code>.</p>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet is being destroyed (destroy)");
    }
}
