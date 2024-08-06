package com.java.springbootproject2.service;

import com.java.springbootproject2.entity.Department;
import com.java.springbootproject2.error.Departmentnotfound;

import java.util.List;

public interface Departmentservice {
    Department savedepartment(Department department);

    List<Department> fetchdepartmentList();

   public Department fetchdepartmentbyid(Long departmentId) throws Departmentnotfound;

    void deletedepartmentbyid(Long departmentId);

    Department updatedepartment(Long departmentId, Department department);

    Department fetchdepartmentbyname(String departmentname);


}
