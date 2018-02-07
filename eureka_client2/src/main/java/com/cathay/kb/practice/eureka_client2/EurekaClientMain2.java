package com.cathay.kb.practice.eureka_client2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class EurekaClientMain2 {

    @Value("${company}")
    private String company;
    @Value("${mail}")
    private String mail;

    @GetMapping("/theFirstFunction")
    public String theFirstFunction() {
        String message = "Spring in cloud : client2";
        System.out.println(message);
        return message;
    }

    @GetMapping("/companyAndMail")
    public String getCompanyAndMail() {
        return String.format("%s-%s", company, mail);
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientMain2.class, args);
    }
}
