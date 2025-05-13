package com.data.session06.controller;

import com.data.session06.model.Employee;
import com.data.session06.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeController extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("search".equals(action)) {
                String name = request.getParameter("name");
                int id = Integer.parseInt(request.getParameter("id"));
                List<Employee> employees = employeeService.searchEmployees(name, id);
                request.setAttribute("employees", employees);
            } else {
                List<Employee> employees = employeeService.getAllEmployees();
                request.setAttribute("employees", employees);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("add".equals(action)) {
                Employee employee = new Employee(0, request.getParameter("name"),
                        java.sql.Date.valueOf(request.getParameter("birthday")),
                        request.getParameter("phone"), request.getParameter("email"),
                        Double.parseDouble(request.getParameter("salary")), request.getParameter("position"));
                employeeService.addEmployee(employee);
            } else if ("update".equals(action)) {
                Employee employee = new Employee(Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"), java.sql.Date.valueOf(request.getParameter("birthday")),
                        request.getParameter("phone"), request.getParameter("email"),
                        Double.parseDouble(request.getParameter("salary")), request.getParameter("position"));
                employeeService.updateEmployee(employee);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                employeeService.deleteEmployee(id);
            }
            response.sendRedirect("employees");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
