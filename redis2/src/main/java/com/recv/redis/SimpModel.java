package com.crud.redis;

import java.io.Serializable;

public class SimpModel implements Serializable {
    private String key;
    private String value;

    public SimpModel(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public SimpModel() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
