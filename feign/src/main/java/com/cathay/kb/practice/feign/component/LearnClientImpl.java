package com.cathay.kb.practice.feign.component;

import com.cathay.kb.practice.feign.ws.LearnClient;
import org.springframework.stereotype.Component;

@Component
public class LearnClientImpl implements LearnClient {
    @Override
    public String theFirstFunction() {
        return "This is feign's LearnClientImpl";
    }
}
