package com.java.springbootproject2.repository;

import com.java.springbootproject2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface Departmentrepository extends JpaRepository<Department, Long>{
  public Department findBydepartmentname(String departmentname);
  public Department findBydepartmentnameIgnoreCase(String departmentname);//it should not conisider capital and small && replace this with above method in service layer so that no need to declare classes again and again
}
