package ch.csbe.modul_295.auth;

import ch.csbe.modul_295.login.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class, AuthController, is responsible for handling authentication-related requests.
 */
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Handles the HTTP POST request for user login.
     *
     * @param loginDto The LoginDto object containing user login information sent in the request body.
     * @return A ResponseEntity with the HTTP status and the JSON response containing a JWT token.
     */
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        // Invoke the authService to obtain a JWT token
        String jwtToken = authService.getJwt(loginDto);

        // Create a ResponseEntity with a 200 OK status and the JWT token in the response body
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jwtToken);
    }
}
