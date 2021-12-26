package com.springboot.user.service;

import com.springboot.user.VO.Department;
import com.springboot.user.VO.ResponseTemplateVo;
import com.springboot.user.entity.User;
import com.springboot.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
      return   userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        ResponseTemplateVo vo= new ResponseTemplateVo();
        User user= userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
