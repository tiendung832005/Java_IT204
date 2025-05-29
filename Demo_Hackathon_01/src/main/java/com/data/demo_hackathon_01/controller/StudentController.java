package com.data.demo_hackathon_01.controller;

import com.data.demo_hackathon_01.model.Student;
import com.data.demo_hackathon_01.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentController", urlPatterns = {"/students"})
public class StudentController extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            try {
                String id = request.getParameter("id");
                studentService.deleteStudent(id);
                response.sendRedirect("students");
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/students.jsp").forward(request, response);
            }
        } else {
            super.doGet(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)) {
            try {
                Student student = new Student();
                student.setId(request.getParameter("id"));
                student.setName(request.getParameter("name"));
                student.setEmail(request.getParameter("email"));
                student.setPhone(request.getParameter("phone"));
                student.setSex(Boolean.parseBoolean(request.getParameter("sex")));
                student.setBod(request.getParameter("bod"));
                student.setAvatar(request.getParameter("avatar"));
                student.setStatus(request.getParameter("status"));

                studentService.updateStudent(student);
                response.sendRedirect("students");
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/update-student.jsp").forward(request, response);
            }
        }
    }

}