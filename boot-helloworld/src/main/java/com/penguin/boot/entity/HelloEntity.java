package com.penguin.boot.entity;

public class HelloEntity {
    private String helloKey;
    private String helloValue;

    public HelloEntity(String helloKey, String helloValue) {
        this.helloKey = helloKey;
        this.helloValue = helloValue;
    }

    public String getHelloKey() {
        return helloKey;
    }

    public void setHelloKey(String helloKey) {
        this.helloKey = helloKey;
    }

    public String getHelloValue() {
        return helloValue;
    }

    public void setHelloValue(String helloValue) {
        this.helloValue = helloValue;
    }
}


