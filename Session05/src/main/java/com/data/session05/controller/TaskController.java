package com.data.session05.controller;


import com.data.session05.model.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;

@WebServlet("/tasks")
public class TaskController extends HttpServlet {
    private List<Task> taskList = new ArrayList<>();
    private int taskIdCounter = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            request.setAttribute("tasks", taskList);
            request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
        } else if (action.equals("add")) {
            request.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            for (Task t : taskList) {
                if (t.getId() == id) {
                    request.setAttribute("task", t);
                    break;
                }
            }
            request.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equals("create")) {
            String desc = request.getParameter("description");
            String dueDate = request.getParameter("dueDate");
            boolean completed = request.getParameter("completed") != null;
            taskList.add(new Task(taskIdCounter++, desc, dueDate, completed));
            response.sendRedirect("tasks");
        } else if (action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            for (Task t : taskList) {
                if (t.getId() == id) {
                    t.setDescription(request.getParameter("description"));
                    t.setDueDate(request.getParameter("dueDate"));
                    t.setCompleted(request.getParameter("completed") != null);
                    break;
                }
            }
            response.sendRedirect("tasks");
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            taskList.removeIf(t -> t.getId() == id);
            response.sendRedirect("tasks");
        }
    }
}

