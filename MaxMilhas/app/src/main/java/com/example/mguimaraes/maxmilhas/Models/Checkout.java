package com.example.mguimaraes.maxmilhas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Checkout implements Serializable {

    @SerializedName("type")
    private String type;
    @SerializedName("target")
    private String target;

    public Checkout(String type, String target) {
        this.type = type;
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}

