package com.capgemini.pcshop.data;

import java.io.Serializable;
import java.util.Collection;

public class Order implements Serializable {

    private static int sequenceId = 1;

    private int orderId;
    private Collection<Integer> parts;

    public Order() {
    }

    public Order(Collection<Integer> parts) {
        this.parts = parts;
    }

    public Order generateOrderId() {
        if (this.orderId == 0) {
            this.orderId = sequenceId++;
        }

        return this;
    }

    public int getOrderId() {
        return orderId;
    }

    public Collection<Integer> getParts() {
        return parts;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setParts(Collection<Integer> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", parts=" + parts +
                '}';
    }
}
