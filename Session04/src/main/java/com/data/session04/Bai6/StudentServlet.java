package com.data.session04.Bai6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Nguyễn Văn A", 20, 8.2));
        studentList.add(new Student(2, "Trần Thị B", 21, 6.5));
        studentList.add(new Student(3, "Lê Văn C", 19, 7.5));
        studentList.add(new Student(4, "Phạm Thị D", 22, 6.8));

        request.setAttribute("students", studentList);
        request.getRequestDispatcher("Bai7.jsp").forward(request, response);
    }
}
