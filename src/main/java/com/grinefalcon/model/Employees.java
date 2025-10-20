package com.grinefalcon.model;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> employeeList;

    public Employees() {
        employeeList = new ArrayList<>();

        // 🧪 Sample data (could be replaced with DB later)
        employeeList.add(new Employee("James", "Vashiri", "EMP001", "james@example.com", "Engineer"));
        employeeList.add(new Employee("Sarah", "Lee", "EMP002", "sarah@example.com", "Manager"));
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
