package by.kapitonov.computer.shop.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfig implements AuditorAware<String> {

    private static final String ANONYMOUS_USER = "ANONYMOUS_USER";

    @Bean
    public AuditorAware<String> auditorProvider() {
        return this::getCurrentAuditor;
    }

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = null;
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                role = String.valueOf(userDetails.getAuthorities());
            } else {
                role = ANONYMOUS_USER;
            }
        }
        return Optional.of(role);
    }
}
