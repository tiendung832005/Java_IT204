package com.data.session05.controller;

import com.data.session05.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String address = request.getParameter("address");

        String error = null;
        int age = 0;

        // Kiểm tra tính hợp lệ
        if (name == null || name.trim().isEmpty() ||
                address == null || address.trim().isEmpty() ||
                ageStr == null || ageStr.trim().isEmpty()) {
            error = "Vui lòng nhập đầy đủ thông tin.";
        } else {
            try {
                age = Integer.parseInt(ageStr);
                if (age <= 0 || age > 100) {
                    error = "Tuổi phải từ 1 đến 100.";
                }
            } catch (NumberFormatException e) {
                error = "Tuổi phải là số nguyên.";
            }
        }

        if (error != null) {
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("Bai3.jsp");
            rd.forward(request, response);
        } else {
            Student student = new Student(name, age, address);
            request.setAttribute("student", student);
            RequestDispatcher rd = request.getRequestDispatcher("studentInfo.jsp");
            rd.forward(request, response);
        }
    }
}