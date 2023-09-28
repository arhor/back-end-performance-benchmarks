package com.github.arhor.benchmarks.spring.webmvc;

public interface UserMapperUtil {
    UserEntity mapToEntity(UserDto.Create dto);
    UserDto.Result mapToDto(UserEntity entity);
}
