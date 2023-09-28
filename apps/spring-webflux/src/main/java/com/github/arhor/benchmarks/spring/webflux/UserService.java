package com.github.arhor.benchmarks.spring.webflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<Void> initialize();
    Flux<UserDto.Result> findAll();
}
