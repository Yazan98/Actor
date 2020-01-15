package com.yazan98.actor.models;

import java.io.Serializable;
import java.util.List;

public class ActorControllerInformation implements Serializable {

    private String name;
    private String description;
    private List<ActorRequestInformation> item;

    public ActorControllerInformation() {

    }

    public ActorControllerInformation(String name, String description, List<ActorRequestInformation> item) {
        this.name = name;
        this.description = description;
        this.item = item;
    }

    public List<ActorRequestInformation> getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItem(List<ActorRequestInformation> item) {
        this.item = item;
    }

    public void setName(String name) {
        this.name = name;
    }

}
