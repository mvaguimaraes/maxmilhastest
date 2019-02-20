package com.example.mguimaraes.maxmilhas.Fragments;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mguimaraes.maxmilhas.Models.Flights;
import com.example.mguimaraes.maxmilhas.R;
import com.example.mguimaraes.maxmilhas.ViewModels.OutboundFlightsViewModel;

public class OutboundFragment extends Fragment {

    private OutboundFlightsViewModel viewModel;

    public OutboundFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(OutboundFlightsViewModel.class);
        viewModel.init();
        viewModel.getFlights().observe(this, flights -> {
            // Update UI.
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_outbound, container, false);
    }

}