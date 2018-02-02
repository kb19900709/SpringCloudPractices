package com.cathay.kb.practice.eureka_client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ApplicationMain {

    @RequestMapping("/theFirstFunction")
    public String theFirstFunction() {
        String message = "Spring in cloud";
        System.out.println(message);
        return message;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
