package com.data.session01;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bai6", value = "/Bai6")
public class Bai6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRegister(request, response);
    }

    private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String className = request.getParameter("className");
        String vehicleType = request.getParameter("vehicleType");
        String licensePlate = request.getParameter("licensePlate");

        boolean isValid = fullName != null && !fullName.isEmpty()
                && className != null && !className.isEmpty()
                && vehicleType != null && !vehicleType.isEmpty()
                && licensePlate != null && !licensePlate.isEmpty();

        String message;
        if (isValid) {
            message = "Đăng ký vé xe thành công cho " + fullName + " - lớp " + className;
        } else {
            message = "Đăng ký thất bại. Vui lòng điền đầy đủ thông tin.";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("/resultRegister.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
