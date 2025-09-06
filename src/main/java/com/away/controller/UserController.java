package com.away.controller;

import com.away.Services.UserService;
import com.away.db.models.UserEntity;
import com.away.dto.createDto.CreateUserDto;
import com.away.dto.responseDto.ResponseUserDto;
import com.away.dto.updateDto.UpdateUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUserDto>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseUserDto>  getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.getUserByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/users/by-email")
    public ResponseEntity<ResponseUserDto> getUserByEmail(@RequestParam String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<ResponseUserDto> updateUser(@RequestBody UpdateUserDto user, @PathVariable long id) {
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<ResponseUserDto> addUser(@RequestBody CreateUserDto user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
