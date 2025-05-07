package com.data.session02;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RegisterAccountServlet ", value = "/RegisterAccountServlet ")
public class RegisterAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Hiển thị form đăng ký
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Lấy thông tin từ form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String ageStr = request.getParameter("age");
        String address = request.getParameter("address");

        // Kiểm tra và xử lý dữ liệu
        boolean isValid = validateData(username, password, fullname);

        // Xử lý age
        int age = 0;
        if (ageStr != null && !ageStr.trim().isEmpty()) {
            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException e) {
                // Xử lý nếu age không phải là số
                isValid = false;
            }
        }

        // Hiển thị kết quả
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='vi'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("    <title>Kết quả đăng ký</title>");
        out.println("    <style>");
        out.println("        body { font-family: Arial, sans-serif; line-height: 1.6; margin: 0; padding: 20px; background-color: #f4f4f4; }");
        out.println("        .container { width: 80%; max-width: 600px; margin: 0 auto; background: white; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 5px; }");
        out.println("        h2 { text-align: center; color: #333; }");
        out.println("        .success { color: green; }");
        out.println("        .error { color: red; }");
        out.println("        .user-info { margin-top: 20px; }");
        out.println("        .user-info p { margin: 5px 0; }");
        out.println("        .btn { display: inline-block; background: #4CAF50; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; text-decoration: none; }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <div class='container'>");

        if (isValid) {
            out.println("        <h2 class='success'>Đăng ký thành công!</h2>");
            out.println("        <div class='user-info'>");
            out.println("            <p><strong>Tên đăng nhập:</strong> " + escapeHtml(username) + "</p>");
            out.println("            <p><strong>Họ và tên:</strong> " + escapeHtml(fullname) + "</p>");

            if (age > 0) {
                out.println("            <p><strong>Tuổi:</strong> " + age + "</p>");
            }

            if (address != null && !address.trim().isEmpty()) {
                out.println("            <p><strong>Địa chỉ:</strong> " + escapeHtml(address) + "</p>");
            }

            out.println("        </div>");
        } else {
            // Đăng ký thất bại
            out.println("        <h2 class='error'>Đăng ký thất bại!</h2>");
            out.println("        <p>Vui lòng kiểm tra lại thông tin đăng ký của bạn.</p>");
        }

        out.println("        <p><a href='register' class='btn'>Quay lại form đăng ký</a></p>");
        out.println("    </div>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Kiểm tra tính hợp lệ của dữ liệu đầu vào
     */
    private boolean validateData(String username, String password, String fullname) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        if (fullname == null || fullname.trim().isEmpty()) {
            return false;
        }


        return true;
    }

    /**
     * Escape HTML để tránh XSS
     */
    private String escapeHtml(String input) {
        if (input == null) {
            return "";
        }
        return input
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }
}
