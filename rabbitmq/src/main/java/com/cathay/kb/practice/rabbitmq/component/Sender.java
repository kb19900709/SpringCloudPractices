package com.cathay.kb.practice.rabbitmq.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            String content = String.format("%s:%s at %s", Integer.toString(i), "This is KB test for rabbit mq", new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date()));
            System.out.println("Sender sent the message : " + content);
            this.rabbitTemplate.convertAndSend("myQueue", content);
        });
    }

}
