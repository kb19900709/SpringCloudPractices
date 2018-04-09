package com.cathay.kb.practice.session.controller;

import com.cathay.kb.practice.session.security.bean.AuthStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("auth")
public class SecurityController extends BaseController {

    @PostMapping("login/success")
    public AuthStatus loginSuccess() {
        return AuthStatus.initAuthStatus("Login success");
    }

    @PostMapping("login/fail")
    public AuthStatus loginFail() {
        return AuthStatus.initAuthStatus("Login fail, please try again");
    }

    @PostMapping("login/out")
    public AuthStatus logout() {
        return AuthStatus.initAuthStatus("Logout success");
    }
}
