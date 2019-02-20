package com.example.mguimaraes.maxmilhas.Services;

import com.example.mguimaraes.maxmilhas.Models.Flights;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("hmg-search")
    Call<Flights> getFlights();

}
