package com.cathay.kb.practice.session.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.expirationTime}")
    private long EXPIRATION＿TIME;

    @Value("${jwt.securityCode}")
    private String SECRET;

    @Value("${jwt.roleKey}")
    private String ROLE_KEY;

    public String getJwtStr(String name, String roles) {
        return Jwts.builder()
                .claim(ROLE_KEY, roles)
                .setSubject(name)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION＿TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public Claims getJwtClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getROLE_KEY() {
        return ROLE_KEY;
    }
}
