package com.github.arhor.benchmarks.spring.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapperUtil mapperUtil;

    @Autowired
    public UserServiceImpl(final UserRepository repository, final UserMapperUtil mapperUtil) {
        this.repository = repository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<UserDto> findAll() {
        return repository
            .findAllUsers()
            .parallelStream()
            .map(mapperUtil::mapToDto)
            .toList();
    }
}
