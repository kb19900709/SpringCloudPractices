package com.cathay.kb.practice.feign.ws;

import com.cathay.kb.practice.feign.component.LearnClientImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "learn", fallback = LearnClientImpl.class)
public interface LearnClient {
    @RequestMapping("/theFirstFunction")
    String theFirstFunction();

    @RequestMapping("/companyAndMail")
    String companyAndMail();
}
