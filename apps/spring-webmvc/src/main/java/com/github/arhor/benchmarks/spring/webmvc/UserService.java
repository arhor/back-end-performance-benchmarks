package com.github.arhor.benchmarks.spring.webmvc;

import java.util.List;

public interface UserService {
    void initialize();
    List<UserDto.Result> findAll();
}
