package com.grinefalcon.controller;

import com.grinefalcon.model.Employees;
import com.grinefalcon.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final Employees employees = new Employees();

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees.getEmployeeList();
    }
}
