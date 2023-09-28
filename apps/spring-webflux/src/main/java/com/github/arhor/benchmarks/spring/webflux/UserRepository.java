package com.github.arhor.benchmarks.spring.webflux;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlResolve"})
public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {

    @Query("SELECT * FROM FIND_ALL_USERS()")
    Flux<UserEntity> findAllUsers();
}
