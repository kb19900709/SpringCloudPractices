package com.cathay.kb.practice.feign.controller;

import com.cathay.kb.practice.feign.ws.LearnClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private LearnClient learnClient;

    @GetMapping("/theFirstFunction")
    public String theFirstFunction() {
        System.out.println("This is feign's controller");
        return learnClient.theFirstFunction();
    }

    @GetMapping("/companyAndMail")
    public String companyAndMail() {
        System.out.println("This is feign's controller");
        return learnClient.companyAndMail();
    }
}
