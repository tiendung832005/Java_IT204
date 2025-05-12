package com.data.session05.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.session05.model.Student;

@WebServlet("/student")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StudentController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/studentForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            // Lấy thông tin từ form
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String address = request.getParameter("address");

            // Tạo đối tượng Student từ dữ liệu form
            Student student = new Student( name, age, address);

            // Đặt đối tượng student vào request để hiển thị trong trang xác nhận
            request.setAttribute("student", student);

            // Chuyển tiếp đến trang xác nhận
            request.getRequestDispatcher("/WEB-INF/views/confirmation.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu tuổi không phải là số
            request.setAttribute("error", "Tuổi phải là một số!");
            request.getRequestDispatcher("/WEB-INF/views/Bai2.jsp").forward(request, response);
        }
    }
}
