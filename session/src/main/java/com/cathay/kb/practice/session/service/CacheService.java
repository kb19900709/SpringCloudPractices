package com.cathay.kb.practice.session.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.function.Supplier;

@Service
public class CacheService {

    public static final String BROWSER = "browser";

    public <T> void setCache(String key, Supplier<T> supplier) {
        getSession().setAttribute(key, supplier.get());
    }

    public <T> void setCache(String key, T object) {
        setCache(key, () -> object);
    }

    public <T> T getCache(String key, Class<T> cacheClass) {
        return (T) getSession().getAttribute(key);
    }

    public HttpSession getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(false);
    }
}
