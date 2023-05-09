package com.example.heavy_service;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrokerConfiguration {
    public static final String QUEUE_NAME_RAW = "to_analyze";
    public static final String QUEUE_NAME_READY = "analyzed";

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE_NAME_RAW, true);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_NAME_READY, true);
    }

}
