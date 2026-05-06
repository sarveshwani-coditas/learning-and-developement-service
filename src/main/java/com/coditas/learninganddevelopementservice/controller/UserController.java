package com.coditas.learninganddevelopementservice.controller;

import com.coditas.learninganddevelopementservice.dto.user.UserRequest;
import com.coditas.learninganddevelopementservice.dto.user.UserResponse;
import com.coditas.learninganddevelopementservice.entity.User;
import com.coditas.learninganddevelopementservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService= userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        UserResponse response = userService.registerUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



}
