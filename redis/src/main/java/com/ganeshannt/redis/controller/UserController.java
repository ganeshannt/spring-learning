package com.ganeshannt.redis.controller;

import com.ganeshannt.redis.model.User;
import com.ganeshannt.redis.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ganeshan Nagarajan
 * @since 25-04-2022
 */

@RestController()
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        boolean result = userService.saveUser(user);
        if (result) return ResponseEntity.ok("User created successfully");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<String> delete(@PathVariable(value = "user_id") long user_id) {
        boolean output = userService.delete(user_id);
        if (output) return ResponseEntity.ok("deleted successfully");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/update/{user_id}")
    public ResponseEntity<User> update(@PathVariable(value = "user_id") long user_id, @RequestBody User user) {
        User updatedUser = userService.update(user_id, user);
        if (updatedUser != null) return ResponseEntity.ok(user);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
