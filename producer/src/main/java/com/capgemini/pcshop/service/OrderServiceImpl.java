package com.capgemini.pcshop.service;

import com.capgemini.pcshop.data.Order;
import com.capgemini.pcshop.data.OrderEvent;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class OrderServiceImpl implements OrderService {

    @Value("${com.capgemini.pcshop.kafka.topic}")
    private String topic;

    private final KafkaProducer<String, OrderEvent> producer;
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    public OrderServiceImpl(KafkaProducer<String, OrderEvent> producer) {
        this.producer = producer;
    }

    @Override
    public Order save(Order order) {
        generateOrderId(order);

        OrderEvent orderEvent = new OrderEvent();
        BeanUtils.copyProperties(order, orderEvent);

        writeEvent(orderEvent);

        return order;
    }

    @Override
    public void writeEvent(OrderEvent orderEvent) {
        producer.send(new ProducerRecord<>(topic, String.valueOf(orderEvent.getOrderId()), orderEvent));
        logger.info("Message sent: " + orderEvent);
    }

    @PreDestroy
    public void closeProducer() {
        producer.close();
    }
}
