package com.grinefalcon.employee_api;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {
    private Employees employees;

    public EmployeeManager() {
        this.employees = new Employees();
        initializeEmployees();
    }

    private void initializeEmployees() {
        // Hard-coded example employees as required by the assignment
        employees.getEmployeeList().add(new Employee("James", "Vashiri", "EMP001", "james@example.com", "Engineer"));
        employees.getEmployeeList().add(new Employee("Sarah", "Lee", "EMP002", "sarah@example.com", "Manager"));
        employees.getEmployeeList()
                .add(new Employee("Michael", "Johnson", "EMP003", "michael@example.com", "Developer"));
        employees.getEmployeeList().add(new Employee("Emily", "Davis", "EMP004", "emily@example.com", "Analyst"));
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
