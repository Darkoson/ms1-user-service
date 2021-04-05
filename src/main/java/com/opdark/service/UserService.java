package com.opdark.service;

import com.opdark.dto.Department;
import com.opdark.dto.UserResponse;
import com.opdark.entity.User;
import com.opdark.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info(" We are in saveUser of UserService");
        return repository.save(user);
    }

    public UserResponse getUserWithDepartment(Long userId) {
        Department department = null;
        log.info(" We are in getUserWithDepartment of UserService");
        User user = repository.getByUserId(userId);
        log.info(" User = "+user);

        if(user!=null){
            department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        }


        return new UserResponse(user, department);
    }
}
