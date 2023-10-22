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


@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UsersRepository usersRepository;
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        return request.getRequestURI().equals("/users") || request.getRequestURI().equals("/auth/login");
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
        String authorization = request.getHeader("Authorization");
        String jwt = authorization.substring("Bearer ".length());
        String userName = jwtService.getUserName(jwt);
        Optional<Users> users = usersRepository.findByUsername(userName);
        if (users.isPresent()){
            List<GrantedAuthority> authorities = List.of(() -> users.get().isAdmin() ? "admin" : "user");
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }
    }
}
