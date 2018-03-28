package com.cathay.kb.practice.session.bean;

import java.util.List;

public class SessionMessage {
    private String sessionMsg;
    private List<String> cookiesMsg;

    public List<String> getCookiesMsg() {
        return cookiesMsg;
    }

    public void setCookiesMsg(List<String> cookiesMsg) {
        this.cookiesMsg = cookiesMsg;
    }

    public String getSessionMsg() {
        return sessionMsg;
    }

    public void setSessionMsg(String sessionMsg) {
        this.sessionMsg = sessionMsg;
    }
}
