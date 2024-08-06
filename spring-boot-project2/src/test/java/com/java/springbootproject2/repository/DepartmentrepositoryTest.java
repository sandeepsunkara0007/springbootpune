package com.java.springbootproject2.repository;

import com.java.springbootproject2.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private Departmentrepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentname("MECH")
                .departmentcode("ME-101")
                .departmentadress("Delhi")
                .build();
        entityManager.persist(department);
    }

    @Test
    public void whenFindByIdThenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals("MECH", department.getDepartmentname());
    }
}
