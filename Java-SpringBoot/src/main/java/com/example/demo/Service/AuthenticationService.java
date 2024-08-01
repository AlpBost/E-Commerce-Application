package com.example.demo.Service;

import com.example.demo.dto.JwtAuthenticationResponse;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.dto.SigninRequest;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
}
