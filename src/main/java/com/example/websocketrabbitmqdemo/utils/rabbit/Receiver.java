package com.example.websocketrabbitmqdemo.utils.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RabbitListener(queues = "QUEUE")
public class Receiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver : " + message);
    }
}
