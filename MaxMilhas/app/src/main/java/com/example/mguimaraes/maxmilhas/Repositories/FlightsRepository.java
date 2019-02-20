package com.example.mguimaraes.maxmilhas.Repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.mguimaraes.maxmilhas.Models.Flights;
import com.example.mguimaraes.maxmilhas.Rest.ApiClient;
import com.example.mguimaraes.maxmilhas.Services.ApiInterface;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class FlightsRepository {
    //private ApiInterface apiInterface;

    public LiveData<Flights> getFlights() {

        final MutableLiveData<Flights> data = new MutableLiveData<>();

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Flights> call = apiService.getFlights();
        call.enqueue(new Callback<Flights>() {
            @Override
            public void onResponse(Call<Flights>call, Response<Flights> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Flights>call, Throwable t) {
                // Log error here since request failed
            }
        });

        return data;
    }
}
