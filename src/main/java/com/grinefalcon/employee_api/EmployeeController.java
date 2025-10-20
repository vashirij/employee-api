package com.grinefalcon.employee_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeManager.getEmployees().getEmployeeList();
    }
}
