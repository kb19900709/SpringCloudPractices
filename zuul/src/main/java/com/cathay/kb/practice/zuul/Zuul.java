package com.cathay.kb.practice.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * SpringCloudApplication = SpringBootApplication + EnableDiscoveryClient + EnableCircuitBreaker
 */
@EnableZuulProxy
@SpringCloudApplication
public class Zuul {
    public static void main(String[] args) {
        SpringApplication.run(Zuul.class, args);
    }
}
