package com.cathay.kb.practice.ribbon.controller;

import com.cathay.kb.practice.ribbon.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @RequestMapping("/theFirstFunction")
    public String theFirstFunction() {
        System.out.println("This is ribbon's controller");
        return myService.theFirstFunction();
    }
}
