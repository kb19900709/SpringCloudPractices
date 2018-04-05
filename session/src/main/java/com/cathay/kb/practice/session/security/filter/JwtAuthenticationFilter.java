package com.cathay.kb.practice.session.security.filter;

import com.cathay.kb.practice.session.security.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Autowired
    private TokenService tokenService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().contains("login");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String jwtStr = Optional.ofNullable(httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION)).orElse("");

        Authentication authentication = null;
        if (!jwtStr.isEmpty()) {
            try {
                authentication = tokenService.getAuthentication(jwtStr);
                String jwt = tokenService.getJwt(authentication);
                httpServletResponse.setHeader(HttpHeaders.AUTHORIZATION, jwt);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
