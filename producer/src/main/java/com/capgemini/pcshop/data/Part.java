package com.capgemini.pcshop.data;


import java.io.Serializable;

public class Part implements Serializable {
    private int id;
    private String name;
    private String producerCode;

    public Part(int Id, String name, String producerCode) {
        this.id = Id;
        this.name = name;
        this.producerCode = producerCode;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }
}
