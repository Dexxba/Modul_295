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

/**
 * This class, AuthConfig, is responsible for configuring security for the application.
 */
@Configuration
public class AuthConfig {

    @Autowired
    private JwtFilter jwtFilter;

    /**
     * This method configures the security filter chain for the application.
     * It specifies which requests are allowed and which require authentication.
     *
     * @param httpSecurity The HttpSecurity object used to configure security.
     * @return A SecurityFilterChain that defines the security configuration.
     * @throws Exception if there's an error during configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // Add the JWT filter before the UsernamePasswordAuthenticationFilter
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            // Permit access without authentication for these endpoints
                            .requestMatchers(HttpMethod.POST, "/users").permitAll()
                            .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                            .requestMatchers("/v3/api-docs").permitAll()
                            .requestMatchers("/swagger-ui/**").permitAll()
                            .requestMatchers("/v3/api-docs/swagger-config").permitAll();

                    authorizationManagerRequestMatcherRegistry
                            // Define required authorities for specific HTTP methods and endpoints
                            .requestMatchers(HttpMethod.DELETE, "/users/*").hasAuthority("admin")
                            .requestMatchers(HttpMethod.POST, "/category").hasAuthority("admin")
                            .requestMatchers(HttpMethod.PUT, "/category/*").hasAuthority("admin")
                            .requestMatchers(HttpMethod.DELETE, "/category/*").hasAuthority("admin")
                            .requestMatchers(HttpMethod.POST, "/product").hasAuthority("admin")
                            .requestMatchers(HttpMethod.PUT, "/product/*").hasAuthority("admin")
                            .requestMatchers(HttpMethod.DELETE, "/product/*").hasAuthority("admin");

                    // All other requests require authentication
                    authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
                })
                // Disable HTTP Basic authentication
                .httpBasic(AbstractHttpConfigurer::disable)
                // Disable Cross-Site Request Forgery (CSRF) protection
                .csrf(AbstractHttpConfigurer::disable)
                // Build the SecurityFilterChain
                .build();
    }
}
