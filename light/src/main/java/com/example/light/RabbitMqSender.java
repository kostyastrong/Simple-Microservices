package com.example.light;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(User user) {
        rabbitTemplate.convertAndSend("to_analyze", user.toJson());
    }
}