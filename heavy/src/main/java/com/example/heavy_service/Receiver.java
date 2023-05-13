package com.example.heavy_service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.example.heavy_service.BrokerConfiguration.QUEUE_NAME_RAW;
import static com.example.heavy_service.BrokerConfiguration.QUEUE_NAME_READY;


@Service
@Slf4j
public class Receiver {
    private final Counter requests;
    private final Counter errors;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Receiver(MeterRegistry meterRegistry) {
        requests = meterRegistry.counter("demo_requests_total");
        errors = meterRegistry.counter("demo_errors");
    }


    @RabbitListener(queues = {QUEUE_NAME_RAW})
    public void receive(String text, MessageHeaders headers) throws InterruptedException {
//        requests.increment();
        log.info("Got new message: " + text + ", headers: " + headers.values());
        // some_analysis
        Thread.sleep(new Random().nextInt() % 10000);
        rabbitTemplate.convertAndSend(QUEUE_NAME_READY, text);
    }
}