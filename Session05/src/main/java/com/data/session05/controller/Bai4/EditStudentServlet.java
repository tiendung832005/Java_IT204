package com.data.session05.controller.Bai4;

import com.data.session05.model.Student1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class EditStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Student1> list = (List<Student1>) getServletContext().getAttribute("studentList");

        Student1 student = null;
        for (Student1 s : list) {
            if (s.getId() == id) {
                student = s;
                break;
            }
        }

        if (student != null) {
            request.setAttribute("student", student);
            request.getRequestDispatcher("editStudent.jsp").forward(request, response);
        } else {
            response.getWriter().println("Không tìm thấy sinh viên.");
        }
    }
}