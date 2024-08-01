package com.example.demo.UserController;

import com.example.demo.Service.JWTServiceImpl.UserServiceImpl;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/addUser")
    public User AddUser(@RequestBody User request) {
        User Nuser = new User(request.getUsername() , request.getPassword(), request.getEmail(), request.getUserType());
        System.out.println("usertype: " + request.getUserType());
        Nuser.setPassword(passwordEncoder.encode(Nuser.getPassword()));
        userServiceImpl.saveUser(Nuser);
        return Nuser;
    }

    @DeleteMapping("/{id}")
    public String DeleteNormalUser(@PathVariable Long id) {
        try {
            userServiceImpl.deleteUser(id);
            return "success";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/DeleteAll")
    public String DeleteAllNormalUser() {
        try {
            userServiceImpl.deleteAll();
            return "success";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}

