package ch.csbe.modul_295.auth;

import ch.csbe.modul_295.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration

public class AuthConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.POST, "/users")
                            .permitAll().requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(HttpMethod.DELETE, "/users/*").hasAuthority("admin")
                            .requestMatchers(HttpMethod.POST, "/category").hasAuthority("admin")
                            .requestMatchers(HttpMethod.PUT, "/category/*").hasAuthority("admin")
                            .requestMatchers(HttpMethod.DELETE, "/category/*").hasAuthority("admin")
                            .requestMatchers(HttpMethod.POST, "/product").hasAuthority("admin")
                            .requestMatchers(HttpMethod.PUT, "/product/*").hasAuthority("admin")
                            .requestMatchers(HttpMethod.DELETE, "/product/*").hasAuthority("admin");
                    authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
                })
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

}
