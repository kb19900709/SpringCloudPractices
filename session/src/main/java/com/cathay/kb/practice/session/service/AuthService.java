package com.cathay.kb.practice.session.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AuthService {
    public boolean isValid(String name, String password) {
        return true;
    }

    public List<String> findUserRoles(String name) {
        return Arrays.asList("ROLE_ADMIN", "AUTH_WRITE");
    }
}
