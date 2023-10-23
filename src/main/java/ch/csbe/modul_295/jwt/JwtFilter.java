package ch.csbe.modul_295.jwt;

import ch.csbe.modul_295.users.Users;
import ch.csbe.modul_295.users.UsersRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * The JwtFilter class is responsible for filtering and authenticating requests using JWT (JSON Web Token).
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsersRepository usersRepository;

    /**
     * Determines whether the filter should be applied to a given request based on the request URI.
     * The filter is not applied to certain URI patterns, such as user registration and authentication endpoints.
     *
     * @param request The HTTP request.
     * @return True if the filter should not be applied, false otherwise.
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getRequestURI().equals("/users") ||
                request.getRequestURI().equals("/auth/login") ||
                request.getRequestURI().startsWith("/swagger-ui") ||
                request.getRequestURI().startsWith("/v3");
    }

    /**
     * Filters and authenticates incoming requests using JWT.
     *
     * @param request     The HTTP request.
     * @param response    The HTTP response.
     * @param filterChain The filter chain to execute further filters.
     * @throws ServletException If there's a servlet-related exception.
     * @throws IOException      If there's an I/O exception.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Extract the JWT from the Authorization header.
        String authorization = request.getHeader("Authorization");
        String jwt = authorization.substring("Bearer ".length());

        // Retrieve the username from the JWT.
        String userName = jwtService.getUserName(jwt);

        // Look up the user in the repository by the username.
        Optional<Users> users = usersRepository.findByUsername(userName);

        if (users.isPresent()) {
            // Define user authorities based on whether the user is an admin or regular user.
            List<GrantedAuthority> authorities = List.of(() -> users.get().isAdmin() ? "admin" : "user");

            // Create an authentication token and set it in the security context.
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Continue the filter chain for authenticated users.
            filterChain.doFilter(request, response);
        }
    }
}
