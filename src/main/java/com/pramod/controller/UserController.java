package com.pramod.controller;

/*Author : Pramod Chamalka*/

import com.pramod.model.User;
import com.pramod.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/api/users")
    public User CreateUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @GetMapping("/api/users")
    public List<User> getAllUser(){
//        User user = new User();
        return userRepository.findAll();
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@RequestBody User user,
                                 @PathVariable long id) throws Exception {

        Optional <User> userOtp = userRepository.findById(id);
        if(userOtp.isEmpty()) {
            throw new Exception("User not found with id " +id);
        }

        User existingUser = userOtp.get();

        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setRole(user.getRole());

        return userRepository.save(existingUser);

    }

    @DeleteMapping("api/users/{id}")
    public String deleteUser(@PathVariable long id) throws Exception {
        Optional<User> userOtp = userRepository.findById(id);
        if(userOtp.isEmpty()) {
            throw new Exception("User not exist with id "+id);
        }

        User dltUser = userOtp.get();

        userRepository.deleteById(userOtp.get().getId());
        return "User '" + dltUser.getFullName() + "' with ID " + id + " deleted successfully!";
    }
}
