package com.example.mguimaraes.maxmilhas.Fragments;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mguimaraes.maxmilhas.Adapters.FlightsAdapter;
import com.example.mguimaraes.maxmilhas.Models.Flights;
import com.example.mguimaraes.maxmilhas.Models.SingleFlight;
import com.example.mguimaraes.maxmilhas.R;
import com.example.mguimaraes.maxmilhas.Rest.ApiClient;
import com.example.mguimaraes.maxmilhas.Services.ApiInterface;
import com.example.mguimaraes.maxmilhas.ViewModels.OutboundFlightsViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OutboundFragment extends Fragment {

    private OutboundFlightsViewModel viewModel;
    @BindView(R.id.filter_results)
    TextView filterResults;
    private Flights flights = new Flights(null, null);
    private ArrayList<SingleFlight> filteredFlights = new ArrayList<>();
    //@BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private FlightsAdapter mAdapter;

    public OutboundFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*viewModel = ViewModelProviders.of(this).get(OutboundFlightsViewModel.class);
        viewModel.init();
        viewModel.getFlights().observe(this, flights -> {
            // Update UI.
        });*/
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_outbound, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        //return inflater.inflate(R.layout.fragment_outbound, container, false);
        getFlights();
        return view;
    }

    private void getFlights() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Flights> call = apiService.getFlights();
        call.enqueue(new Callback<Flights>() {
            @Override
            public void onResponse(Call<Flights>call, Response<Flights> response) {
                flights = response.body();
                filteredFlights = flights.getOutboundFlights();
                mAdapter = new FlightsAdapter(flights.sort(flights.getOutboundFlights()));
                recyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<Flights>call, Throwable t) {
                // Log error here since request failed
            }
        });
    }

}