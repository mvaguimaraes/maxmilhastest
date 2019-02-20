package com.example.mguimaraes.maxmilhas.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mguimaraes.maxmilhas.Models.Flights;
import com.example.mguimaraes.maxmilhas.Repositories.FlightsRepository;

import javax.inject.Inject;

public class OutboundFlightsViewModel extends ViewModel {

    private LiveData<Flights> flights;
    private FlightsRepository flightsRepo;

    @Inject
    public OutboundFlightsViewModel(FlightsRepository flightsRepo) {
        this.flightsRepo = flightsRepo;
    }

    public OutboundFlightsViewModel(){}

    public void init() {
        if (this.flights != null) {
            return;
        }
        flights = flightsRepo.getFlights();
    }

    public LiveData<Flights> getFlights() {
        return this.flights;
    }
}