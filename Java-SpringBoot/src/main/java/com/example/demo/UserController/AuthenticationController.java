package com.example.demo.UserController;

import com.example.demo.Service.AuthenticationService;
import com.example.demo.Service.JWTServiceImpl.UserServiceImpl;
import com.example.demo.dto.JwtAuthenticationResponse;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.dto.SigninRequest;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserServiceImpl userServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity <User> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest) {
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }
}
