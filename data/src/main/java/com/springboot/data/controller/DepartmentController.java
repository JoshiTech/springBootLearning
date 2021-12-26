package com.springboot.data.controller;

import com.springboot.data.Entity.Department;
import com.springboot.data.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
      log.info("saveDepartment method in DepartmentController Class");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("findDepartmentById method in DepartmentController class");
        return departmentService.findDepartmentById(departmentId);}
}
