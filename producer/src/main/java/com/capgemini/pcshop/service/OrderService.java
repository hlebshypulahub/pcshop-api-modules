package com.capgemini.pcshop.service;

import com.capgemini.pcshop.data.Order;
import com.capgemini.pcshop.data.OrderEvent;

public interface OrderService {

    void writeEvent(OrderEvent orderEvent);

    Order save(Order order);

    default void generateOrderId(Order order) {
        order.generateOrderId();
    }

}
