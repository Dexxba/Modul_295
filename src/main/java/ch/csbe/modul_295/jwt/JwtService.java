package ch.csbe.modul_295.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private final String secret = "$2h@WzR9&pL#6XqW";
    public String createJwt(String userName){
        return Jwts
                .builder()
                .setIssuer("CsBe")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() * 60 * 60 * 24 * 20))
                .setSubject(userName)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    public String getUserName(String jwt){
        return Jwts
                .parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();
    }
}
