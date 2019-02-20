package com.example.mguimaraes.maxmilhas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pricing implements Serializable {

    @SerializedName("ota")
    private Ota ota;
    @SerializedName("airlineName")
    private String airlineName;
    @SerializedName("isInternational")
    private Boolean isInternational;
    @SerializedName("bestPriceAt")
    private String bestPriceAt;
    @SerializedName("mmBestPriceAt")
    private String mmBestPriceAt;
    @SerializedName("savingPercentage")
    private String savingPercentage;

    public Pricing(Ota ota, String airlineName, Boolean isInternational, String bestPriceAt, String mmBestPriceAt, String savingPercentage) {
        this.ota = ota;
        this.airlineName = airlineName;
        this.isInternational = isInternational;
        this.bestPriceAt = bestPriceAt;
        this.mmBestPriceAt = mmBestPriceAt;
        this.savingPercentage = savingPercentage;
    }

    public Pricing(Ota ota) {
        this.ota = ota;
    }

    public Ota getOta() {
        return ota;
    }

    public void setOta(Ota ota) {
        this.ota = ota;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Boolean getInternational() {
        return isInternational;
    }

    public void setInternational(Boolean international) {
        isInternational = international;
    }

    public String getBestPriceAt() {
        return bestPriceAt;
    }

    public void setBestPriceAt(String bestPriceAt) {
        this.bestPriceAt = bestPriceAt;
    }

    public String getMmBestPriceAt() {
        return mmBestPriceAt;
    }

    public void setMmBestPriceAt(String mmBestPriceAt) {
        this.mmBestPriceAt = mmBestPriceAt;
    }

    public String getSavingPercentage() {
        return savingPercentage;
    }

    public void setSavingPercentage(String savingPercentage) {
        this.savingPercentage = savingPercentage;
    }
}
