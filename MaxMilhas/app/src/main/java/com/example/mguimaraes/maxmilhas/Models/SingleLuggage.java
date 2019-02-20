package com.example.mguimaraes.maxmilhas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SingleLuggage implements Serializable {

    @SerializedName("weight")
    private String weight;
    @SerializedName("prices")
    private ArrayList<Integer> prices;

    public SingleLuggage(String weight, ArrayList<Integer> prices) {
        this.weight = weight;
        this.prices = prices;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public ArrayList<Integer> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Integer> prices) {
        this.prices = prices;
    }
}
