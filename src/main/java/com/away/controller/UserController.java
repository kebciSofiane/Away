package com.away.controller;

import com.away.Services.UserService;
import com.away.db.models.UserEntity;
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

    @GetMapping("/users/")
    public ResponseEntity<List<UserEntity>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity>  getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.getUserByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<UserEntity> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user, @PathVariable long id) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }
    @DeleteMapping("/users/id/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
