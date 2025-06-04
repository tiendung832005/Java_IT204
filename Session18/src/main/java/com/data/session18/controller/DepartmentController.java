package com.data.session18.controller;

import com.data.session18.dto.DepartmentDTO;
import com.data.session18.entity.Department;
import com.data.session18.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DepartmentController {

    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("department")
    public String getAll(Model model) {
        List<Department> departments = departmentService.findAll();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();

        departments.forEach(department -> {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setId(department.getId());
            departmentDTO.setDepartmentName(department.getDepartmentName());
            departmentDTOs.add(departmentDTO);
        });

        System.out.println(departmentDTOs);

        model.addAttribute("departmentDTOs", departmentDTOs);
        return "department_list";
    }
}