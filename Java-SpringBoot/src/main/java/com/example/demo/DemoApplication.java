package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableWebSecurity
public class DemoApplication /*implements CommandLineRunner*/ {

//	@Autowired
//	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	public void run(String...args) {
//		User adminAccount = userRepository.findByRole(Role.SuperUser);
//		if(null== adminAccount) {
//			User user = new User();
//
//			user.setEmail("cc");
//			user.setUsername("a");
//			user.setUserType(Role.SuperUser);
//			user.setPassword(new BCryptPasswordEncoder().encode("a"));
//			userRepository.save(user);
//		}
//	}


}
