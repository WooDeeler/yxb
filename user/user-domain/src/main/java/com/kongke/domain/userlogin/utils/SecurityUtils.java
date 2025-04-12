package com.kongke.domain.userlogin.utils;

import org.apache.commons.codec.digest.DigestUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class SecurityUtils {
    private static final String JWT_SECRET = "your-jwt-secret-key";
    private static final long JWT_EXPIRATION = 86400000L; // 24 hours

    public static String md5Hex(String text) {
        return DigestUtils.md5Hex(text);
    }

    public static String md5Hex(String text, String salt) {
        return DigestUtils.md5Hex(text + salt);
    }

    public static String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }
}