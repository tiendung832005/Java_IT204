package com.data.session18.controller;


import com.data.session18.dto.EmployeeDTO;
import com.data.session18.entity.Employee;
import com.data.session18.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employee")
    public String getAll(Model model) {
        List<Employee> employees = employeeService.findAll();

        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setFullName(employee.getFullName());
            if (employee.getDepartment() != null) {
                employeeDTO.setDepartmentName(employee.getDepartment().getDepartmentName());
            } else {
                employeeDTO.setDepartmentName("No Department");
            }
            employeeDTOs.add(employeeDTO);
        }

        model.addAttribute("employeeDTOs", employeeDTOs);
        return "employee_list";
    }
}