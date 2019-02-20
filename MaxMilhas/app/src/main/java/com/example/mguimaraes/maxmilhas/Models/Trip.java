package com.example.mguimaraes.maxmilhas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Trip implements Serializable {

    @SerializedName("layover")
    private String layover;
    @SerializedName("stops")
    private String stops;
    @SerializedName("aircraft")
    private String aircraft;
    @SerializedName("duration")
    private String duration;
    @SerializedName("carrier")
    private String carrier;
    @SerializedName("flightNumber")
    private String flightNumber;
    @SerializedName("from")
    private String from;
    @SerializedName("isInternational")
    private Boolean isInternational;
    @SerializedName("departureDate")
    private Date departureDate;
    @SerializedName("arrivalDate")
    private Date arrivalDate;
    @SerializedName("to")
    private String to;

    public Trip(String layover, String stops, String aircraft, String duration, String carrier, String flightNumber, String from, Boolean isInternational, Date departureDate, Date arrivalDate, String to) {
        this.layover = layover;
        this.stops = stops;
        this.aircraft = aircraft;
        this.duration = duration;
        this.carrier = carrier;
        this.flightNumber = flightNumber;
        this.from = from;
        this.isInternational = isInternational;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.to = to;
    }

    public Trip() {
    }

    public String getLayover() {
        return layover;
    }

    public void setLayover(String layover) {
        this.layover = layover;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Boolean getInternational() {
        return isInternational;
    }

    public void setInternational(Boolean international) {
        isInternational = international;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
