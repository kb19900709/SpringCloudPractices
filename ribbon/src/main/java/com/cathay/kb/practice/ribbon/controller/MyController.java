package com.cathay.kb.practice.ribbon.controller;

import com.cathay.kb.practice.ribbon.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/theFirstFunction")
    public String theFirstFunction() {
        System.out.println("This is ribbon's controller");
        return myService.theFirstFunction();
    }

    @GetMapping("/companyAndMail")
    public String companyAndMail() {
        System.out.println("This is ribbon's controller");
        return myService.companyAndMail();
    }
}
