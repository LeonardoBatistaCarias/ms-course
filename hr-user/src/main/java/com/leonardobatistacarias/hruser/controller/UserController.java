package com.leonardobatistacarias.hruser.controller;

import com.leonardobatistacarias.hruser.repository.UserRepository;
import com.leonardobatistacarias.hruser.repository.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var response = repository.findById(id).get();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        var response = repository.findByEmail(email);
        return ResponseEntity.ok().body(response);
    }
}