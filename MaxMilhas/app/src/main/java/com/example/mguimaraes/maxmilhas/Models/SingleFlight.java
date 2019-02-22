package com.example.mguimaraes.maxmilhas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("serial")
public class SingleFlight implements Serializable {

    @SerializedName("stops")
    private String stops;
    @SerializedName("airline")
    private String airline;
    @SerializedName("otaAvailableIn")
    private String otaAvailableIn;
    @SerializedName("duration")
    private int duration;
    @SerializedName("flightNumber")
    private String flightNumber;
    @SerializedName("airlineTarget")
    private String airlineTarget;
    @SerializedName("from")
    private String from;
    @SerializedName("id")
    private String id;
    @SerializedName("choosedTripType")
    private String choosedTripType;
    @SerializedName("availableIn")
    private String availableIn;
    @SerializedName("trips")
    private ArrayList<Trip> trips;
    @SerializedName("departureDate")
    private Date departureDate;
    @SerializedName("arrivalDate")
    private Date arrivalDate;
    @SerializedName("cabin")
    private String cabin;
    @SerializedName("pricing")
    private Pricing pricing;
    @SerializedName("direction")
    private String direction;
    @SerializedName("to")
    private String to;

    public SingleFlight(String stops, String airline, String otaAvailableIn, int duration, String flightNumber, String airlineTarget, String from, String id, String choosedTripType, String availableIn, ArrayList<Trip> trips, Date departureDate, Date arrivalDate, String cabin, Pricing pricing, String direction, String to) {
        this.stops = stops;
        this.airline = airline;
        this.otaAvailableIn = otaAvailableIn;
        this.duration = duration;
        this.flightNumber = flightNumber;
        this.airlineTarget = airlineTarget;
        this.from = from;
        this.id = id;
        this.choosedTripType = choosedTripType;
        this.availableIn = availableIn;
        this.trips = trips;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.cabin = cabin;
        this.pricing = pricing;
        this.direction = direction;
        this.to = to;
    }

    public SingleFlight() {
    }

    public SingleFlight(Pricing pricing) {
        this.pricing = pricing;
    }

    public SingleFlight(int duration, Pricing pricing) {
        this.duration = duration;
        this.pricing = pricing;
    }
    public SingleFlight(ArrayList<Trip> trips, Date departureDate) {
        this.trips = trips;
        this.departureDate = departureDate;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOtaAvailableIn() {
        return otaAvailableIn;
    }

    public void setOtaAvailableIn(String otaAvailableIn) {
        this.otaAvailableIn = otaAvailableIn;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirlineTarget() {
        return airlineTarget;
    }

    public void setAirlineTarget(String airlineTarget) {
        this.airlineTarget = airlineTarget;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChoosedTripType() {
        return choosedTripType;
    }

    public void setChoosedTripType(String choosedTripType) {
        this.choosedTripType = choosedTripType;
    }

    public String getAvailableIn() {
        return availableIn;
    }

    public void setAvailableIn(String availableIn) {
        this.availableIn = availableIn;
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
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

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
