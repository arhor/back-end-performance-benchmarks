package com.github.arhor.benchmarks.spring.webmvc;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlResolve"})
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("SELECT * FROM FIND_ALL_USERS()")
    List<UserEntity> findAllUsers();
}
