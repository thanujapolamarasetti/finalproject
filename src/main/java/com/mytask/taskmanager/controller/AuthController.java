package com.mytask.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mytask.taskmanager.dto.FarmerRegisterRequest;
import com.mytask.taskmanager.dto.LoginRequest;
import com.mytask.taskmanager.dto.LoginResponse;
import com.mytask.taskmanager.model.User;
import com.mytask.taskmanager.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = authService.login(request.getUsername(), request.getPassword());

        LoginResponse response = new LoginResponse();
        response.setUserId(user.getUserId());
        response.setUsername(user.getUsername());
        response.setRole(user.getRole());

        return response;
    }
  
    
    @PostMapping("/register/farmer")
    public User registerFarmer(@RequestBody FarmerRegisterRequest request) {

        return authService.registerFarmer(
                request.getUsername(),
                request.getPassword(),
                request.getPhoneNumber(),
                request.getLocation()
        );
    }

    @GetMapping("/profile/{id}")
    public User getProfile(@PathVariable Long id) {
        return authService.getUserById(id);
    }

  }
