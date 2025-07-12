package com.icbt.billing.onlinebillingsystem.util;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/12/2025
 */
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final String SECRET_KEY = "BECB93AB1B1D5847A5A8657C8EE28";
    private static final long EXPIRATION_TIME = 1000 * 24;

    // Generate JWT token
    public static String generateToken(String username, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }

    public static Claims validateToken(String token) throws Exception {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new Exception("Invalid or expired JWT token: " + e.getMessage());
        }
    }

    // Extract username from token
    public static String extractUsername(String token) throws Exception {
        return validateToken(token).getSubject();
    }
}