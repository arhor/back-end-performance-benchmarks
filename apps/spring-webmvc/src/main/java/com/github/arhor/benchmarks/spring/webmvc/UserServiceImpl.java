package com.github.arhor.benchmarks.spring.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    @Transactional
    public void initialize() {
        repository.deleteAll();
        repository.save(new UserEntity("username", "password"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto.Result> findAll() {
        final var users = repository.findAllUsers();
        final var result = new ArrayList<UserDto.Result>(users.size());

        for (final var user : users) {
            result.add(mapperUtil.mapToDto(user));
        }
        return result;
    }
}
