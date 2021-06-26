package com.leonardobatistacarias.hroauth.controller;

import com.leonardobatistacarias.hroauth.feignclient.entity.User;
import com.leonardobatistacarias.hroauth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        var response = userService.findByEmail(email);
        return ResponseEntity.ok().body(response);
    }
}
