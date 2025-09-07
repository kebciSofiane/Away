package com.away.controller;

import com.away.Services.UserService;
import com.away.db.models.UserEntity;
import com.away.dto.createDto.CreateUserDto;
import com.away.dto.responseDto.ResponseUserDto;
import com.away.dto.updateDto.UpdateUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUserDto>> getUsers() {
        List<ResponseUserDto>  responseUserDtos = userService.getAllUsers();
        return responseUserDtos.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseUserDto>  getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserByUserId(id));
    }

    @GetMapping("/users/by-email")
    public ResponseEntity<ResponseUserDto> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUserDto> addUser(@RequestBody CreateUserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<ResponseUserDto> updateUser(@RequestBody UpdateUserDto updateUserDto, @PathVariable long id) {
        return  ResponseEntity.ok(userService.updateUser(updateUserDto, id));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
