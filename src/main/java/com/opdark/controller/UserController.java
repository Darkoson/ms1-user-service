package com.opdark.controller;

import com.opdark.dto.UserResponse;
import com.opdark.entity.User;
import com.opdark.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService service;


    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("inside the controller");
        return service.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserResponse getUserWithDepartment(@PathVariable("id") Long userId){
        return service.getUserWithDepartment(userId);

    }
}
