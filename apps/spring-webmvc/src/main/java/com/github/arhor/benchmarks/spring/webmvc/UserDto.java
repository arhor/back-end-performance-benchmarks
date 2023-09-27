package com.github.arhor.benchmarks.spring.webmvc;

import java.time.LocalDateTime;

public record UserDto(
    Long id,
    String username,
    LocalDateTime createdDateTime,
    LocalDateTime updatedDateTime
) {
}
