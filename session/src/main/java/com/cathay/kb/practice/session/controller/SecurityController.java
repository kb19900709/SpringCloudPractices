package com.cathay.kb.practice.session.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class SecurityController extends BaseController {

    @PostMapping("login/success")
    public Map<String, Object> loginSuccess() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "Login success");
        return result;
    }

    @PostMapping("login/fail")
    public Map<String, Object> loginFail() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "Login fail, please try again");
        return result;
    }
}
