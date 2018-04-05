package com.cathay.kb.practice.session.service;

import com.cathay.kb.practice.session.service.prop.JwtProp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Autowired
    private JwtProp jwtProp;

    public String getJwtStr(String name, String roles) {
        return Jwts.builder()
                .claim(jwtProp.getRoleKey(), roles)
                .setSubject(name)
                .setExpiration(new Date(System.currentTimeMillis() + jwtProp.getExpirationTime()))
                .signWith(SignatureAlgorithm.HS512, jwtProp.getSecurityCode())
                .compact();
    }

    public Claims getJwtClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtProp.getSecurityCode())
                .parseClaimsJws(token)
                .getBody();
    }

    public String getROLE_KEY() {
        return jwtProp.getRoleKey();
    }
}