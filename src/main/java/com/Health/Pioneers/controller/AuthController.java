package com.Health.Pioneers.controller;

import com.Health.Pioneers.dao.UserRepository;
import com.Health.Pioneers.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserRepository userRepository;



    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
//        User user = userRepository.findByUsername(loginRequest.getUsername());
//        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }

       return new ResponseEntity<>("User", HttpStatus.OK);

    }
}
