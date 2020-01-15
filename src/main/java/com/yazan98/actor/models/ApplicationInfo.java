package com.yazan98.actor.models;

import java.io.Serializable;

public class ApplicationInfo implements Serializable {

    private String id;
    private String applicationName;
    private String description;
    private String schema;

    public ApplicationInfo() {

    }

    public ApplicationInfo(String id, String applicationName, String description, String schema) {
        this.id = id;
        this.applicationName = applicationName;
        this.description = description;
        this.schema = schema;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
