package com.capgemini.pcshop.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.util.logging.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

@Slf4j
public class OrderEventCustomSerializer implements Serializer<OrderEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, OrderEvent data) {
        try {
            if (data == null) {
                System.out.println("Null received at serializing");
                return null;
            }

            return objectMapper.writeValueAsBytes(data);

        } catch (Exception e) {
            throw new SerializationException("Error when serializing Order to byte[]");
        }
    }

    @Override
    public void close() {
    }
}
