package com.github.arhor.benchmarks.spring.webmvc;

import org.springframework.stereotype.Component;

@Component
public class UserMapperUtilImpl implements UserMapperUtil {

    @Override
    public UserDto mapToDto(final UserEntity entity) {
        return new UserDto(
            entity.id(),
            entity.username(),
            entity.createdDateTime(),
            entity.updatedDateTime()
        );
    }
}
