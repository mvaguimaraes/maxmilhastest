package com.example.mguimaraes.maxmilhas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Ota implements Serializable {

    @SerializedName("adult")
    private Adult adult;
    @SerializedName("luggage")
    private Luggage luggage;
    @SerializedName("checkout")
    private Checkout checkout;
    @SerializedName("familyCode")
    private String familyCode;
    @SerializedName("fareTotal")
    private String fareTotal;
    @SerializedName("saleTotal")
    private Double saleTotal;

    public Ota(Adult adult, Luggage luggage, Checkout checkout, String familyCode, String fareTotal, Double saleTotal) {
        this.adult = adult;
        this.luggage = luggage;
        this.checkout = checkout;
        this.familyCode = familyCode;
        this.fareTotal = fareTotal;
        this.saleTotal = saleTotal;
    }

    public Ota(Double saleTotal) {
        this.saleTotal = saleTotal;
    }

    public Adult getAdult() {
        return adult;
    }

    public void setAdult(Adult adult) {
        this.adult = adult;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

    public String getFareTotal() {
        return fareTotal;
    }

    public void setFareTotal(String fareTotal) {
        this.fareTotal = fareTotal;
    }

    public Double getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(Double saleTotal) {
        this.saleTotal = saleTotal;
    }
}
