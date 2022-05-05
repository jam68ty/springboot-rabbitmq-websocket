package com.example.websocketrabbitmqdemo.utils.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

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
    public void sendDialogue(String sendUserId, String receiveUserId,String msg) {
        logger.info(logSenderFormat, msg);
        String routingKey = sendUserId + "_" + receiveUserId + new Date().getTime();
        logger.info(logRoutingKey, routingKey);
        logger.info(receiver, receiveUserId);
        this.rabbitTemplate.convertAndSend(exchange, routingKey, msg);
    }

}
