package ch.csbe.modul_295.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class AuthConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.POST, "/users").permitAll().requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
            authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
        });

        httpSecurity.httpBasic(Customizer.withDefaults());
        return httpSecurity

                .csrf(AbstractHttpConfigurer::disable).build();
    }
}
