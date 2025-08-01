package tech.tawan.barber_project.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import tech.tawan.barber_project.entity.User;

import java.util.Date;

@Service
public class JwtService {
    private final String secret = "mZ5R2hJ9o6W3LcX8kFj7dVNs+YypL4fAxuDq9bXm5E0=\n";

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("name", user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1 day
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, User user) {
        return extractEmail(token).equals(user.getEmail());
    }
}
