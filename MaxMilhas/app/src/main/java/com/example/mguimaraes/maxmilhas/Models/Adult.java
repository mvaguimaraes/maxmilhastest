package com.example.mguimaraes.maxmilhas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Adult implements Serializable {

    @SerializedName("quantity")
    private String quantity;
    @SerializedName("fare")
    private String fare;
    @SerializedName("fees")
    private ArrayList<Fee> fees;

    public Adult(String quantity, String fare, ArrayList<Fee> fees) {
        this.quantity = quantity;
        this.fare = fare;
        this.fees = fees;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public ArrayList<Fee> getFees() {
        return fees;
    }

    public void setFees(ArrayList<Fee> fees) {
        this.fees = fees;
    }
}

