package com.github.arhor.benchmarks.spring.webmvc;

import org.springframework.stereotype.Component;

@Component
public class UserMapperUtilImpl implements UserMapperUtil {

    @Override
    public UserEntity mapToEntity(final UserDto.Create dto) {
        return new UserEntity(
            dto.username(),
            dto.password()
        );
    }

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
