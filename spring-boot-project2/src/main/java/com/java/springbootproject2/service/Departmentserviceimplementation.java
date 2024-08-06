package com.java.springbootproject2.service;

import com.java.springbootproject2.entity.Department;
import com.java.springbootproject2.error.Departmentnotfound;
import com.java.springbootproject2.repository.Departmentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Departmentserviceimplementation implements Departmentservice {
    @Autowired
    private  Departmentrepository departmentRepository;



    @Override
    public Department savedepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchdepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchdepartmentbyid(Long departmentId) throws Departmentnotfound {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new Departmentnotfound("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deletedepartmentbyid(Long departmentId) {
        departmentRepository.deleteById((departmentId));
    }

    @Override
    public Department updatedepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentname()) && !"".equalsIgnoreCase(department.getDepartmentname())){
            depDB.setDepartmentname(department.getDepartmentname());
        }

        if(Objects.nonNull(department.getDepartmentcode()) && !"".equalsIgnoreCase(department.getDepartmentcode())){
            depDB.setDepartmentname(department.getDepartmentcode());
        }

        if(Objects.nonNull(department.getDepartmentadress()) && !"".equalsIgnoreCase(department.getDepartmentadress())){
            depDB.setDepartmentname(department.getDepartmentadress());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchdepartmentbyname(String departmentname) {
        return departmentRepository.findBydepartmentname(departmentname);
    }
}
