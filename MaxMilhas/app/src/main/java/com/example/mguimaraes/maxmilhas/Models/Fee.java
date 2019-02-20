package com.example.mguimaraes.maxmilhas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Fee implements Serializable {

    @SerializedName("type")
    private String type;
    @SerializedName("id")
    private String id;
    @SerializedName("value")
    private String value;
    @SerializedName("group")
    private String group;
    @SerializedName("passengerType")
    private String passengerType;

    public Fee(String type, String id, String value, String group, String passengerType) {
        this.type = type;
        this.id = id;
        this.value = value;
        this.group = group;
        this.passengerType = passengerType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }
}
