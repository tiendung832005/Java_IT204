package com.data.session01;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bai1", value = "/Bai1")
public class Bai1 extends HttpServlet {
    private String message;

    public void init() {
        message = "Bài 1";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>Mô tả chức năng từng thành phần:\n" +
                "Client (Trình duyệt):\n" +
                "\n" +
                "Giao diện người dùng.\n" +
                "\n" +
                "Gửi yêu cầu (request) đến server qua HTTP.\n" +
                "\n" +
                "Hiển thị phản hồi (HTML, JSON, v.v.) từ server.\n" +
                "\n" +
                "Web Server (Apache, Nginx, hoặc Tomcat):\n" +
                "\n" +
                "Nhận HTTP request từ client.\n" +
                "\n" +
                "Chuyển tiếp request đến Application Server hoặc phục vụ tài nguyên tĩnh (HTML, CSS, JS).\n" +
                "\n" +
                "Application Server (Java EE, Spring Boot, Tomcat embedded):\n" +
                "\n" +
                "Xử lý logic nghiệp vụ của ứng dụng (business logic).\n" +
                "\n" +
                "Giao tiếp với cơ sở dữ liệu.\n" +
                "\n" +
                "Trả kết quả về Web Server.\n" +
                "\n" +
                "Database (MySQL, PostgreSQL, Oracle...):\n" +
                "\n" +
                "Lưu trữ dữ liệu ứng dụng.\n" +
                "\n" +
                "Nhận các truy vấn (query) từ Application Server và trả kết quả. </p>");
        out.println("<p>Giải thích cách các thành phần tương tác:\n" +
                "Khi người dùng gửi yêu cầu từ trình duyệt (Client), yêu cầu này được gửi đến Web Server thông qua giao thức HTTP. Web Server sẽ xác định xem đây là yêu cầu tài nguyên tĩnh (ví dụ: file HTML hoặc ảnh) hay yêu cầu xử lý logic. Nếu là yêu cầu xử lý logic, Web Server sẽ chuyển tiếp đến Application Server, nơi chứa các component Java như Servlet, Controller (Spring), hoặc EJB. Application Server sẽ thực hiện các logic cần thiết, truy xuất dữ liệu từ Database nếu cần, sau đó gửi kết quả (thường dưới dạng HTML hoặc JSON) ngược về Web Server. Cuối cùng, Web Server gửi phản hồi này lại cho Client, hiển thị thông tin cho người dùng.</p>");
    }

    public void destroy() {
    }
}
