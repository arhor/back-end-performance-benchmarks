package com.github.arhor.benchmarks.spring.webflux;

public interface UserMapperUtil {
    UserDto.Result mapToDto(UserEntity entity);
}
