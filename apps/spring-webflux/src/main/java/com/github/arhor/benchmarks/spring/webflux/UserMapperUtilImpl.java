package com.github.arhor.benchmarks.spring.webflux;

import org.springframework.stereotype.Component;

@Component
public class UserMapperUtilImpl implements UserMapperUtil {

    @Override
    public UserDto.Result mapToDto(final UserEntity entity) {
        return new UserDto.Result(
            entity.id(),
            entity.username(),
            entity.createdDateTime(),
            entity.updatedDateTime()
        );
    }
}
