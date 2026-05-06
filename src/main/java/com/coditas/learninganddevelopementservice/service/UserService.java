package com.coditas.learninganddevelopementservice.service;

import com.coditas.learninganddevelopementservice.dto.LoginRequest;
import com.coditas.learninganddevelopementservice.dto.LoginResponse;
import com.coditas.learninganddevelopementservice.dto.user.UserRequest;
import com.coditas.learninganddevelopementservice.dto.user.UserResponse;
import com.coditas.learninganddevelopementservice.entity.User;
import com.coditas.learninganddevelopementservice.mapper.UserMapper;
import com.coditas.learninganddevelopementservice.repository.UserRepository;
import com.coditas.learninganddevelopementservice.security.JWTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authmanager;

    @Autowired
    public UserService(UserRepository userRepository, JWTService jwtService, UserMapper userMapper){
        this.userRepository=userRepository;
        this.userMapper=userMapper;
        this.jwtService=jwtService;
    }

    public UserResponse registerUser(UserRequest userRequest) {
       User user = userMapper.toEntity(userRequest);
       User savedUser = userRepository.save(user);
       return userMapper.toDTO(savedUser);
    }

    public LoginResponse login(LoginRequest request) {

        Authentication authentication =
                authmanager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        if(authentication.isAuthenticated()){
            User user = (User) authentication.getPrincipal();

            String accessToken = jwtService.generateAccessToken(user);

            return LoginResponse.builder()
                    .accessToken(accessToken)
                    .build();
        }
        else{
            throw new UsernameNotFoundException("User does not found for id");
        }
    }
}
