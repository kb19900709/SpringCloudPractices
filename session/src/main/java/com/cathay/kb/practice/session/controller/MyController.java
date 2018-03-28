package com.cathay.kb.practice.session.controller;

import com.cathay.kb.practice.session.bean.SessionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @RequestMapping("test")
    public SessionMessage cookie(@RequestParam("browser") String browser) {
        SessionMessage sm = new SessionMessage();
        Object sessionBrowser = session.getAttribute("browser");

        if (sessionBrowser == null) {
            sm.setSessionMsg("不存在session，设置browser=" + browser);
            session.setAttribute("browser", browser);
        } else {
            sm.setSessionMsg("存在session，browser=" + sessionBrowser.toString());
        }

        List<String> cookiesMsg = new ArrayList<>();
        Optional.ofNullable(request.getCookies()).ifPresent(cookies ->
                Arrays.stream(cookies).forEach(cookie ->
                        cookiesMsg.add(cookie.getName() + " : " + cookie.getValue())
                )
        );

        sm.setCookiesMsg(cookiesMsg);

        return sm;
    }
}
