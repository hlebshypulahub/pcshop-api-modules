package com.capgemini.pcshop.service;

import com.capgemini.pcshop.data.OrderEvent;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceConfig {

    private final KafkaProducer<String, OrderEvent> kafkaProducer;

    public OrderServiceConfig(KafkaProducer<String, OrderEvent> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(kafkaProducer);
    }

}
