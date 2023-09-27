package com.github.arhor.benchmarks.spring.webmvc;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.function.Supplier;

@SpringBootApplication(proxyBeanMethods = false)
@EnableJdbcAuditing(modifyOnCreate = false, dateTimeProviderRef = "currentDateTimeProvider")
@EnableJdbcRepositories(basePackages = {"com.github.arhor.benchmarks.spring.webmvc"})
@EnableTransactionManagement
public class Main {

    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(final UserRepository repository) {
        return args -> {
            repository.deleteAll();
            repository.save(new UserEntity("username", "password"));
        };
    }

    @Bean
    public Supplier<LocalDateTime> currentDateTimeSupplier() {
        return () -> {
            var systemUTC = Clock.systemUTC();
            var timestamp = LocalDateTime.now(systemUTC);

            return timestamp.truncatedTo(ChronoUnit.MILLIS);
        };
    }

    @Bean
    public DateTimeProvider currentDateTimeProvider(final Supplier<LocalDateTime> currentDateTimeSupplier) {
        return () -> Optional.of(currentDateTimeSupplier.get());
    }

    @Bean
    public FlywayConfigurationCustomizer flywayConfigurationCustomizer() {
        return it -> it.loggers("slf4j");
    }
}
