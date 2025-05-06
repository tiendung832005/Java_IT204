package com.data.session01.Bai8;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bai8", value = "/Bai8")
public class Bai8 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Task> tasks = TaskManager.getInstance().getAllTasks();
        request.setAttribute("tasks", tasks);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String jobName = request.getParameter("jobName");
            if (jobName != null && !jobName.trim().isEmpty()) {
                TaskManager.getInstance().addTask(jobName);
            }
        } else if ("changeStatus".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String currentStatus = request.getParameter("currentStatus");
            String newStatus = currentStatus.equals("Completed") ? "Doing" : "Completed";
            TaskManager.getInstance().changeStatus(id, newStatus);
        }

        response.sendRedirect(request.getContextPath() + "/tasks");
    }

    public void destroy() {
    }
}
