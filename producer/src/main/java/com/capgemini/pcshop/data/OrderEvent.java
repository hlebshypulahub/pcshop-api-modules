package com.capgemini.pcshop.data;

import java.util.Collection;

public class OrderEvent {
    private int orderId;
    //    private String origin;
    private Collection<Integer> parts;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

//    public String getOrigin() {
//        return origin;
//    }
//
//    public void setOrigin(String origin) {
//        this.origin = origin;
//    }

    public Collection<Integer> getParts() {
        return parts;
    }

    public void setParts(Collection<Integer> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "orderId=" + orderId +
                ", parts=" + parts +
                '}';
    }
}
