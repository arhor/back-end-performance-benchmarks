package com.github.arhor.benchmarks.spring.webflux;

import java.time.LocalDateTime;

public sealed interface UserDto {

    record Result(
        Long id,
        String username,
        LocalDateTime createdDateTime,
        LocalDateTime updatedDateTime) implements UserDto {
    }
}
