package com.capgemini.pcshop.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class OrderKey implements Serializable {

    private int Id;
    private LocalDateTime createdAt;

    public OrderKey(int id, LocalDateTime createdAt) {
        Id = id;
        this.createdAt = createdAt;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderKey)) return false;
        OrderKey orderKey = (OrderKey) o;
        return Id == orderKey.Id && Objects.equals(createdAt, orderKey.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, createdAt);
    }
}
