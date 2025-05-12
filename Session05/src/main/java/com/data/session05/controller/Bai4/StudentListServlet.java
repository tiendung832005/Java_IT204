package com.data.session05.controller.Bai4;

import com.data.session05.model.Student1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class StudentListServlet extends HttpServlet {
    private static final int STUDENTS_PER_PAGE = 5;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student1> allStudents = (List<Student1>) getServletContext().getAttribute("studentList");
        if (allStudents == null) {
            allStudents = new java.util.ArrayList<>();
            getServletContext().setAttribute("studentList", allStudents);
        }

        int totalStudents = allStudents.size();
        int totalPages = (int) Math.ceil((double) totalStudents / STUDENTS_PER_PAGE);

        int page = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            try {
                page = Integer.parseInt(pageParam);
                if (page < 1) page = 1;
                if (page > totalPages) page = totalPages;
            } catch (NumberFormatException ignored) {}
        }

        int start = (page - 1) * STUDENTS_PER_PAGE;
        int end = Math.min(start + STUDENTS_PER_PAGE, totalStudents);

        List<Student1> studentsForPage = allStudents.subList(start, end);

        request.setAttribute("students", studentsForPage);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.getRequestDispatcher("listStudent.jsp").forward(request, response);
    }
}
