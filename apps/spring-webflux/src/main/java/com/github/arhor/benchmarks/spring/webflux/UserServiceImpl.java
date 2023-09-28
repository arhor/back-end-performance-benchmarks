package com.github.arhor.benchmarks.spring.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Mono<Void> initialize() {
        return repository.deleteAll()
            .then(Mono.fromCallable(() -> repository.save(new UserEntity("username", "password"))))
            .then();
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<UserDto.Result> findAll() {
        return repository
            .findAllUsers()
            .map(mapperUtil::mapToDto);
    }
}
