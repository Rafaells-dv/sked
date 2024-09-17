package com.gnbarbersop.scheduler.controller;

import com.gnbarbersop.scheduler.dto.AuthDto;
import com.gnbarbersop.scheduler.dto.AuthResponseDto;
import com.gnbarbersop.scheduler.dto.UserDto;
import com.gnbarbersop.scheduler.entity.UserEntity;
import com.gnbarbersop.scheduler.repository.UserRepository;
import com.gnbarbersop.scheduler.service.TokenService;
import com.gnbarbersop.scheduler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto data) {
        if(userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        UserEntity newUser = new UserEntity(data.name(), data.email(), data.phone(), encryptedPassword, data.role());

        userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthDto data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((UserEntity) auth.getPrincipal());
            return ResponseEntity.ok(new AuthResponseDto(token));
        } catch (AuthenticationException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
