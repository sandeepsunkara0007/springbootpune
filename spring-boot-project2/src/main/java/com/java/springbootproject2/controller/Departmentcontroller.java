package com.java.springbootproject2.controller;

import com.java.springbootproject2.entity.Department;
import com.java.springbootproject2.error.Departmentnotfound;
import com.java.springbootproject2.service.Departmentservice;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Departmentcontroller {
    @Autowired
    private Departmentservice departmentservice;
    private final Logger logger = LoggerFactory.getLogger(Departmentcontroller.class); // Corrected logger initialization

    @PostMapping("/departments")
    public Department savedepartment(@Valid @RequestBody Department department){
        logger.info("Inside save department of departmentcontroller");
        return departmentservice.savedepartment(department);
    }

    @GetMapping("/departments1")
    public List<Department> fetchdepartmentList(){
        logger.info("Inside fetch department list of departmentcontroller");
        return departmentservice.fetchdepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchdepartmentbyid(@PathVariable("id") Long departmentId) throws Departmentnotfound {
        return departmentservice.fetchdepartmentbyid(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deletedepartmentbyid(@PathVariable("id") Long departmentId){
        departmentservice.deletedepartmentbyid(departmentId);
        return "Deleted department successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updatedepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentservice.updatedepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchdepartmentbyname(@PathVariable("name") String departmentname){
        return departmentservice.fetchdepartmentbyname(departmentname);
    }
}
