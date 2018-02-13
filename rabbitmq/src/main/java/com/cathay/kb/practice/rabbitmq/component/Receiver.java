package com.cathay.kb.practice.rabbitmq.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "myQueue")
public class Receiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver got the message : " + message);
    }

}
