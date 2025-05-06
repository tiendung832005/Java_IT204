package com.data.session01;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bai4", value = "/Bai4")
public class Bai4 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<p>Bước 1: Tạo ứng dụng web Java\n" +
                "\n" +
                "Tạo cấu trúc dự án theo chuẩn Gradle:\n" +
                "src/main/java, src/main/webapp, src/main/resources.\n" +
                "\n" +
                "Viết một Servlet đơn giản để xử lý yêu cầu và một trang index.html trong thư mục webapp.\n" +
                "\n" +
                "Cấu hình build.gradle để sử dụng plugin war và khai báo dependency jakarta.servlet-api.\n" +
                "\n" +
                "Bước 2: Build file WAR\n" +
                "\n" +
                "Mở terminal và chạy lệnh:" +
                "Sau khi build thành công, file .war sẽ nằm trong thư mục:\n" +
                "build/libs/my-webapp.war." +
                "Bước 3: Cài đặt và khởi động Tomcat\n" +
                "\n" +
                "Tải Tomcat từ trang chủ: https://tomcat.apache.org/\n" +
                "\n" +
                "Giải nén và vào thư mục apache-tomcat-X.X.X\n" +
                "\n" +
                "Copy file my-webapp.war vào thư mục:\n" +
                "webapps/\n" +
                "\n" +
                "Bước 4: Khởi động Tomcat\n" +
                "\n" +
                "Chạy file:\n" +
                "\n" +
                "startup.bat (trên Windows)\n" +
                "\n" +
                "startup.sh (trên Linux/Mac)\n" +
                "\n" +
                "Mở trình duyệt và truy cập: <p>");
    }

    public void destroy() {
    }
}
