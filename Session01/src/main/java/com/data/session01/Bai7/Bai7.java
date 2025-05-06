package com.data.session01.Bai7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bai7", value = "/Bai7")
public class Bai7 extends HttpServlet {
    private static final List<StudentTicket> studentTickets = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        studentTickets.add(new StudentTicket("Nguyễn Văn A", "12A1", "Xe đạp", "29A-123.45"));
        studentTickets.add(new StudentTicket("Trần Thị B", "11B2", "Xe máy", "30B-678.90"));
        studentTickets.add(new StudentTicket("Lê Văn C", "10C3", "Xe máy", "31C-111.22"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        request.setAttribute("studentList", studentTickets);
        request.getRequestDispatcher("/Bai7.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
