package ch.csbe.modul_295.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * This class provides services for working with JSON Web Tokens (JWTs).
 */
@Service
public class JwtService {
    // The secret key used for signing and verifying JWTs. It should be kept secure.
    private final String secret = "$2h@WzR9&pL#6XqW";

    /**
     * Creates a new JWT with the provided user name as its subject.
     *
     * @param userName The user name to be included in the JWT.
     * @return A JWT as a string.
     */
    public String createJwt(String userName) {
        return Jwts
                .builder()
                .setIssuer("CsBe") // Set the issuer of the JWT.
                .setIssuedAt(new Date(System.currentTimeMillis())) // Set the issuance date of the JWT.
                .setExpiration(new Date(System.currentTimeMillis() + 60L * 60L * 24L * 20L * 1000L)) // Set the expiration date (20 days in milliseconds).
                .setSubject(userName) // Set the subject (user name) of the JWT.
                .signWith(SignatureAlgorithm.HS256, secret) // Sign the JWT using the provided secret key and HMAC-SHA-256 algorithm.
                .compact(); // Compact the JWT into a string.
    }

    /**
     * Extracts the user name from a given JWT.
     *
     * @param jwt The JWT from which to extract the user name.
     * @return The user name extracted from the JWT.
     */
    public String getUserName(String jwt) {
        return Jwts
                .parser()
                .setSigningKey(secret) // Set the secret key for verifying the JWT.
                .parseClaimsJws(jwt) // Parse the JWT claims with the provided key.
                .getBody()
                .getSubject(); // Get the subject (user name) from the JWT's claims.
    }
}
