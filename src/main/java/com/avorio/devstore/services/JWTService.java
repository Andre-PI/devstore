package com.avorio.devstore.services;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService{

    private String secretKey;
    public String generateToken(String username) {
        Map<String, Object>  claims = new HashMap<>();
        return Jwts.builder()
            .claims()
            .add(claims)
            .subject(username)
            .issuedAt( new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 10))
            .and()
            .signWith(generateKey())
            .compact();

    }

    private Key generateKey() {
        KeyGenerator keyGenerator;
        try {
            keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey key = keyGenerator.generateKey();
            secretKey = Base64.getEncoder().encodeToString(key.getEncoded());
            byte[] keyByte = Base64.getDecoder().decode(secretKey);
            return Keys.hmacShaKeyFor(keyByte);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Exception");
        }
    }
}
