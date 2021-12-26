package com.springboot.user.controller;

import com.springboot.user.VO.ResponseTemplateVo;
import com.springboot.user.entity.User;
import com.springboot.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/users")
@Slf4j

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("inside UserController saveUser Method");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside UserController getUserWithDepartment method");
        return userService.getUserWithDepartment(userId);
    }




}
