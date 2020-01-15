package com.yazan98.actor.models;

import java.io.Serializable;
import java.util.List;

public class ActorRequestInformation<T> implements Serializable {

    private String name;
    private String description;
    private String method;
    private String path;
    private List<ActorHeader> headers;
    private String port;
    private String host;
}
