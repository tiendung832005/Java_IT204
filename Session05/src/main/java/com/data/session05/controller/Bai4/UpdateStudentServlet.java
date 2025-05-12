package com.data.session05.controller.Bai4;

import com.data.session05.model.Student1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String address = request.getParameter("address");

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            age = 0;
        }

        List<Student1> list = (List<Student1>) getServletContext().getAttribute("studentList");

        for (Student1 s : list) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                s.setAddress(address);
                break;
            }
        }

        response.sendRedirect("studentList");
    }
}
