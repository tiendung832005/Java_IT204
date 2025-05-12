package com.data.session05.controller;

import com.data.session05.model.Student1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        List<Student1> list = (List<Student1>) getServletContext().getAttribute("studentList");

        if (list != null) {
            list.removeIf(student -> student.getId() == id);
        }

        response.sendRedirect("studentList");
    }
}
