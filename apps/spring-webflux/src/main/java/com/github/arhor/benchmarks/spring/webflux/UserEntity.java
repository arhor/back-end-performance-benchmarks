package com.github.arhor.benchmarks.spring.webflux;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(UserEntity.TABLE_NAME)
@Immutable
public record UserEntity(
    @Id
    @Column("id")
    Long id,

    @Column("username")
    String username,

    @Column("password")
    String password,

    @Version
    @Column("version")
    Long version,

    @CreatedDate
    @Column("created_date_time")
    LocalDateTime createdDateTime,

    @LastModifiedDate
    @Column("updated_date_time")
    LocalDateTime updatedDateTime
) {
    public static final String TABLE_NAME = "users";

    public UserEntity(final String username, final String password) {
        this(null, username, password, null, null, null);
    }
}
