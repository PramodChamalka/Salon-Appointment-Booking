package com.pramod.controller;

/*Author : Pramod Chamalka*/

import com.pramod.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public User getUser(){
        User user = new User();

        user.setFullName("John Doe");
        user.setEmail("john.doe@gmail.com");
        user.setRole("Employee");
        user.setPhone("1234567890");

        return user;
    }
}
