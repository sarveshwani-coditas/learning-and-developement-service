package com.coditas.learninganddevelopementservice.service;

import com.coditas.learninganddevelopementservice.dto.user.UserRequest;
import com.coditas.learninganddevelopementservice.dto.user.UserResponse;
import com.coditas.learninganddevelopementservice.entity.User;
import com.coditas.learninganddevelopementservice.mapper.UserMapper;
import com.coditas.learninganddevelopementservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository=userRepository;
        this.userMapper=userMapper;
    }

    public UserResponse registerUser(UserRequest userRequest) {
       User user = userMapper.toEntity(userRequest);
       User savedUser = userRepository.save(user);
       return userMapper.toDTO(savedUser);
    }
}
