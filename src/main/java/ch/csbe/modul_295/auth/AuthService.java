package ch.csbe.modul_295.auth;

import ch.csbe.modul_295.jwt.JwtService;
import ch.csbe.modul_295.login.LoginDto;
import ch.csbe.modul_295.users.Users;
import ch.csbe.modul_295.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * The AuthService class is responsible for providing authentication-related services.
 */
@Service
public class AuthService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private JwtService jwtService;

    // Create an instance of BCryptPasswordEncoder for password hashing
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * Retrieves a JWT (JSON Web Token) for a user based on their login information.
     *
     * @param loginDto The LoginDto object containing user login information.
     * @return A JWT token as a String.
     * @throws ResponseStatusException with HTTP status NOT_FOUND if the user is not found.
     * @throws ResponseStatusException with HTTP status UNAUTHORIZED if the provided password is incorrect.
     */
    public String getJwt(LoginDto loginDto) {
        // Attempt to find a user by their username, or throw an exception with status NOT_FOUND
        Users user = usersRepository.findByUsername(loginDto.getUsername()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // Check if the provided password matches the hashed password stored in the database
        if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            // If the password doesn't match, throw an exception with status UNAUTHORIZED
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        // If the username and password are valid, create and return a JWT for the user
        return jwtService.createJwt(user.getUsername());
    }
}
