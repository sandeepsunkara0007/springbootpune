package com.java.springbootproject2.service;

import com.java.springbootproject2.entity.Department;
import com.java.springbootproject2.repository.Departmentrepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentserviceTest {
    @Autowired
    private Departmentservice departmentservice;
    @MockBean
    private Departmentrepository departmentrepository;


    @BeforeEach
    void setUp() {
        Department department=Department.builder()
                .departmentname("IT")
                .departmentadress("Ahmedabad")
                .departmentcode("IT-06")
                .build();
        Mockito.when(departmentrepository.findBydepartmentname("IT")).thenReturn(department);

    }
    @Test
    @DisplayName("Get data based on valid department name")
    public void wenvaliddepartmentnamethenshouldfound(){
        String departmentname = "IT";
        Department found=departmentservice.fetchdepartmentbyname(departmentname);
        assertEquals(departmentname, found.getDepartmentname());

    }

}