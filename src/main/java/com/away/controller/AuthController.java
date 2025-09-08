package com.away.controller;

import com.away.Services.UserService;
import com.away.db.models.UserEntity;
import com.away.db.repositories.UserRepository;
import com.away.dto.createDto.CreateUserDto;
import com.away.dto.loginDto.LoginRequestDto;
import com.away.dto.responseDto.ResponseUserDto;
import com.away.exceptions.user.UserNotFoundException;
import com.away.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserService userService;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService, UserService userService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        UserEntity user = userRepository.findByUserName(loginRequestDto.getUserName())
                .orElseThrow(() -> new UserNotFoundException(loginRequestDto.getUserName()));

        if (!passwordEncoder.matches(loginRequestDto.getUserPass(), user.getUserPass())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getUserName());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseUserDto> addUser(@RequestBody @Valid CreateUserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }


}
