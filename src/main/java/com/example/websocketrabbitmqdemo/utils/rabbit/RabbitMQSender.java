package com.example.websocketrabbitmqdemo.utils.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RabbitMQSender {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 發送消息
    public void send(String msg) {
        System.out.println();
        System.out.println("Sender : " + msg);
        this.rabbitTemplate.convertAndSend("QUEUE", msg);
    }

    String logSenderFormat = "Sender:{}";
    String logRoutingKey = "routingKey:{}";
    String exchange = "amq.topic";
    String receiver = "receiveUserId:{}";

    /**
     * 發送最新訊息
     *
     * @param msg
     * @param sendUserId
     */
    public void sendDialogue(String msg, String sendUserId, String receiveUserId) {
        logger.info(logSenderFormat, msg);
        String routingKey = sendUserId + ":" + receiveUserId;
        logger.info(logRoutingKey, sendUserId);
        logger.info(receiver, receiveUserId);
        this.rabbitTemplate.convertAndSend(exchange, routingKey, msg);
    }

}
