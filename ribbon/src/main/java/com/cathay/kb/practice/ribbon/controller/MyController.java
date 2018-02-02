package com.cathay.kb.practice.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/theFirstFunction")
    public String theFirstFunction() {
        return restTemplate.getForEntity("http://LEARN/theFirstFunction", String.class).getBody();
    }
}
