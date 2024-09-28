package com.bsharp.recipe.Recipe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.ZonedDateTime;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JdbcAuditConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        // Return the current auditor (e.g., the current logged-in user)
        return () -> Optional.of("defaultAuditor");
    }

    @Bean
    public DateTimeProvider auditingDateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now());
    }
}
