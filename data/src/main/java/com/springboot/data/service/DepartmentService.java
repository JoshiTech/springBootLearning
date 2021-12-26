package com.springboot.data.service;

import com.springboot.data.Entity.Department;
import com.springboot.data.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDepartment( Department department) {
      log.info("saveDepartment method in DepartmentService class");
        return departmentRepository.save(department);
    }


    public Department findDepartmentById(Long departmentId) {
        log.info("findDepartmentById method in DepartmentService class");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
