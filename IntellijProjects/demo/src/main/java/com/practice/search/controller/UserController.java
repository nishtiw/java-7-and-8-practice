package com.practice.search.controller;

import com.practice.search.entity.User;
import com.practice.search.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            User user2 = userService.addUser(user);
            return ResponseEntity.ok(user2);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/search/{pageNumber}/{pageSize}/{sortProperty}")
    public ResponseEntity<List<User>> searchUserByName(@RequestParam("query") String name, @PathVariable("pageNumber") Integer pageNumber,
                                                       @PathVariable("pageSize") Integer pageSize,
                                                       @PathVariable("sortProperty") String sortProperty) {
        try {
            List<User> users = userService.searchUserByName(name, pageNumber, pageSize, sortProperty);
            if(users.size() <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
