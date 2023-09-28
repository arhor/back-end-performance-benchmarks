package com.github.arhor.benchmarks.spring.webflux;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.function.Supplier;

@SpringBootApplication(proxyBeanMethods = false)
@EnableR2dbcAuditing(modifyOnCreate = false, dateTimeProviderRef = "currentDateTimeProvider")
@EnableR2dbcRepositories(basePackages = {"com.github.arhor.benchmarks.spring.webflux"})
@EnableTransactionManagement
public class Main {

    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(final UserService service) {
        return (args) -> service.initialize().block();
    }

    @Bean
    public Supplier<LocalDateTime> currentDateTimeSupplier() {
        return () -> LocalDateTime.now(Clock.systemUTC()).truncatedTo(ChronoUnit.MILLIS);
    }

    @Bean
    public DateTimeProvider currentDateTimeProvider(final Supplier<LocalDateTime> currentDateTimeSupplier) {
        return () -> Optional.of(currentDateTimeSupplier.get());
    }

    @Bean
    public FlywayConfigurationCustomizer flywayConfigurationCustomizer() {
        return (it) -> it.loggers("slf4j");
    }
}
