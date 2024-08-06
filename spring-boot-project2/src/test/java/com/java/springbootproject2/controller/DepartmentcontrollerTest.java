package com.java.springbootproject2.controller;

import com.java.springbootproject2.entity.Department;
import com.java.springbootproject2.error.Departmentnotfound;
import com.java.springbootproject2.service.Departmentservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Departmentcontroller.class)
class DepartmentcontrollerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Departmentservice departmentService;

    private Department department;
    private Long departmentid;


    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentadress("Ahmedabad")
                .departmentcode("IT-06")
                .departmentname("IT")
                .departmentid(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentadress("Ahmedabad")
                .departmentcode("IT-06")
                .departmentname("IT")
                .departmentid(1L)
                .build();
        Mockito.when(departmentService.savedepartment(inputDepartment))
                .thenReturn(department);
        mockMvc.perform(post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"departmentadress\":\"Ahmedabad\",\n" +
                                "    \"departmentcode\":\"IT-06\",\n" +
                                "    \"departmentname\":\"IT\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchdepartmentbyid(1L))
                .thenReturn(department);
        mockMvc.perform(get("/departments/1", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentname")
                        .value(department.getDepartmentname()));
    }
}
