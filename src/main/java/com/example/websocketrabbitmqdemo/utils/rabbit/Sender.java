package com.example.websocketrabbitmqdemo.utils.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 發送消息
    public void send(String msg) {
        System.out.println();
        System.out.println("Sender : " + msg);
        this.rabbitTemplate.convertAndSend("QUEUE", msg);
    }
}
