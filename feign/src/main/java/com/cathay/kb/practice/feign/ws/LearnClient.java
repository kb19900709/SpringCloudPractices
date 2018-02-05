package com.cathay.kb.practice.feign.ws;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("learn")
public interface LearnClient {
    @RequestMapping("/theFirstFunction")
    String theFirstFunction();
}
