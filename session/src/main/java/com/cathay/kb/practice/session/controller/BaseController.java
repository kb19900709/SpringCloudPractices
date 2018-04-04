package com.cathay.kb.practice.session.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.function.Supplier;

abstract public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    public <T> void setCache(String key, Supplier<T> supplier) {
        getHttpSession().setAttribute(key, supplier.get());
    }

    public <T> void setCache(String key, T object) {
        setCache(key, () -> object);
    }

    public <T> T getCache(String key, Class<T> cacheClass) {
        return (T) getHttpSession().getAttribute(key);
    }

    public HttpSession getHttpSession() {
        return request.getSession(false);
    }
}
