package com.gnbarbersop.scheduler.controller;

import com.gnbarbersop.scheduler.dto.UserDto;
import com.gnbarbersop.scheduler.entity.UserEntity;
import com.gnbarbersop.scheduler.repository.UserRepository;
import com.gnbarbersop.scheduler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ResponseEntity<?> createUser(@RequestParam String userEmail) {
        UserDetails user = userRepository.findByEmail(userEmail);
        return ResponseEntity.ok(user);
    }
}
