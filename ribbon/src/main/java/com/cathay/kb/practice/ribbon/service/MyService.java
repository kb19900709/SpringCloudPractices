package com.cathay.kb.practice.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "theFirstFunctionErrorBack")
    public String theFirstFunction() {
        System.out.println("This is ribbon's service");
        return restTemplate.getForEntity("http://LEARN/theFirstFunction", String.class).getBody();
    }

    private String theFirstFunctionErrorBack(){
        return "there is no response";
    }
}
