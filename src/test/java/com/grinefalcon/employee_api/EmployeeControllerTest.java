package com.grinefalcon.employee_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].employee_id").value("EMP001"));
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee newEmployee = new Employee("Test", "User", "EMP999", "test.user@example.com", "Tester");
        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newEmployee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employee_id").value("EMP999"));
    }

    @Test
    public void testAddEmployeeWithMissingFields() throws Exception {
        // Missing email and title
        String json = "{" +
                "\"first_name\":\"Edge\"," +
                "\"last_name\":\"Case\"," +
                "\"employee_id\":\"EMP1000\"}";
        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employee_id").value("EMP1000"));
    }

    @Test
    public void testAddDuplicateEmployeeId() throws Exception {
        Employee duplicate = new Employee("James", "Vashiri", "EMP001", "james.dup@example.com", "Engineer");
        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(duplicate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employee_id").value("EMP001"));
    }

    @Test
    public void testAddEmployeeWithInvalidEmail() throws Exception {
        Employee invalidEmail = new Employee("Invalid", "Email", "EMP1001", "not-an-email", "QA");
        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidEmail)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("not-an-email"));
    }
}
