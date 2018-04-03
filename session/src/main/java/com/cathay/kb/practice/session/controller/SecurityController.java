package com.cathay.kb.practice.session.controller;

import com.cathay.kb.practice.session.bean.SessionMessage;
import com.cathay.kb.practice.session.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping("test")
    public SessionMessage cookie(@RequestParam("browser") String browser) {
        SessionMessage result = new SessionMessage();

        String sessionBrowser = cacheService.getCache(CacheService.BROWSER, String.class);
        if (sessionBrowser == null) {
            result.setSessionMsg(String.format("%s, session has no attributes，set browser: %s, sessionId: %s", "123", browser, cacheService.getSession().getId()));
            cacheService.setCache(CacheService.BROWSER, browser);
        } else {
            result.setSessionMsg(String.format("%s, session has attributes，browser: %s, sessionId: %s", "123", sessionBrowser, cacheService.getSession().getId()));
        }

        return result;
    }
}
