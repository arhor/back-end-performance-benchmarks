package com.github.arhor.benchmarks.spring.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Flux;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(final UserService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public Flux<UserDto.Result> getUserById() {
        return service.findAll();
    }
}
