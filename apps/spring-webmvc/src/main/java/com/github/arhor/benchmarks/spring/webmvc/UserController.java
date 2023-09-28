package com.github.arhor.benchmarks.spring.webmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(final UserService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public List<UserDto.Result> getUserById() {
        return service.findAll();
    }
}
