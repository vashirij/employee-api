package com.grinefalcon.employee_api;

public class Employee {
    private String first_name;
    private String last_name;
    private String employee_id;
    private String email;
    private String title;

    // Constructor
    public Employee(String first_name, String last_name, String employee_id, String email, String title) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.employee_id = employee_id;
        this.email = email;
        this.title = title;
    }

    // Getter methods
    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

        // Setter methods
        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public void setEmployee_id(String employee_id) {
            this.employee_id = employee_id;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setTitle(String title) {
            this.title = title;
        }
}
