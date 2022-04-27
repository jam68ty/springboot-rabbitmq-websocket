package com.example.websocketrabbitmqdemo.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "QUEUE")
public class Receiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver : " + message);
    }
}
