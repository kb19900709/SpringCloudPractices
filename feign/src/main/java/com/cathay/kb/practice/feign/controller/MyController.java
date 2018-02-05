package com.cathay.kb.practice.feign.controller;

import com.cathay.kb.practice.feign.ws.LearnClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private LearnClient learnClient;

    @RequestMapping("/theFirstFunction")
    public String theFirstFunction() {
        System.out.println("This is feign's controller");
        return learnClient.theFirstFunction();
    }
}
