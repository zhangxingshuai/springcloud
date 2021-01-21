package com.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "生产者: " + new Date();
        amqpTemplate.convertAndSend("hello", context);
    }
}
