package com.yazan98.actor.models;

public class ActorHeader {

    private String key;
    private String value;

    public ActorHeader(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}

