package com.example.demo.Service;

import com.example.demo.dto.SignUpRequest;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface UserService {
    User signup(SignUpRequest signUpRequest);
    Optional<User> findByUsername(String username);
    void saveUser(User user);
    void deleteUser(Long id);
    void deleteAll();
}
