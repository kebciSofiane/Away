package com.away.security;

import com.away.db.models.UserEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "CHANGE_ME_TO_A_LONG_SECRET_KEY_256_BITS_MINIMUM";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 heure

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generateToken(UserEntity user) {
        return Jwts.builder()
                .setSubject(user.getUserEmail())
                .claim("userId", user.getUserId())
                .claim("userName", user.getUserName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token, UserEntity user) {
        final String email = extractClaims(token).getSubject();
        return (email.equals(user.getUserEmail())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
