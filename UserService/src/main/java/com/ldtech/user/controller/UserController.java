package com.ldtech.user.controller;

import com.ldtech.user.entites.User;
import com.ldtech.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

//    create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

//    get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable long userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

//    get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

//    update user
    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUserById(@RequestBody User user, @PathVariable long userId){
        userService.updateUserById(user, userId);
        return ResponseEntity.ok("User Details Updated successfully!");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUsersById(@PathVariable long userId){
        userService.deleteByUserId(userId);
        return ResponseEntity.ok("User Deleted Successfully!");
    }



}
