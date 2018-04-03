package com.cathay.kb.practice.session.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAuthenticationFilter extends GenericFilterBean {

    @Autowired
    private TokenValidationService tokenValidationService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String jwtStr = Optional.ofNullable(httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION))
                .orElse("");

        Authentication authentication = null;
        if (!jwtStr.isEmpty()) {
            try {
                authentication = tokenValidationService.getAuthentication(jwtStr);
                String jwt = tokenValidationService.getJwt(authentication);
                httpServletResponse.setHeader(HttpHeaders.AUTHORIZATION, jwt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
