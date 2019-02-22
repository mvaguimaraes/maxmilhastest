package com.example.mguimaraes.maxmilhas.Fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mguimaraes.maxmilhas.Activities.FilterActivity;
import com.example.mguimaraes.maxmilhas.Activities.SortActivity;
import com.example.mguimaraes.maxmilhas.Adapters.FlightsAdapter;
import com.example.mguimaraes.maxmilhas.Models.Flights;
import com.example.mguimaraes.maxmilhas.Models.SingleFlight;
import com.example.mguimaraes.maxmilhas.R;
import com.example.mguimaraes.maxmilhas.Rest.ApiClient;
import com.example.mguimaraes.maxmilhas.Services.ApiInterface;
import com.example.mguimaraes.maxmilhas.ViewModels.OutboundFlightsViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class OutboundFragment extends Fragment {

    public static final int REQUEST_CODE = 1;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private OutboundFlightsViewModel viewModel;
    @BindView(R.id.filter_results)
    TextView filterResults;
    @BindView(R.id.filter_flights)
    TextView filterFlights;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.sort_layout)
    RelativeLayout sortLayout;
    @BindView(R.id.filter_layout)
    RelativeLayout filterLayout;
    private Flights flights = new Flights(null, null);
    private ArrayList<SingleFlight> filteredFlights = new ArrayList<>();
    private FlightsAdapter mAdapter;
    public static String morningCheck = "false", afternoonCheck = "false", eveningCheck = "false", lateNightCheck = "false", straightFlightCheck = "false", oneStopCheck = "false", isClean = "false";

    public OutboundFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(OutboundFlightsViewModel.class);
        viewModel.init();
        viewModel.getFlights().observe(this, flights -> {
            // Update UI.
                System.out.println("Rinoceronte: " + flights.getOutboundFlights().size());
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
        View view = inflater.inflate(R.layout.fragment_outbound, container, false);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this, view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
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
                setFilterTexts(filteredFlights.size());
                initiateAdapter(filteredFlights);

            }

            @Override
            public void onFailure(Call<Flights>call, Throwable t) {
                // Log error here since request failed
            }
        });
    }

    private void setFilterTexts(int qty) {
        if (qty == 1) {
            filterResults.setText(String.valueOf(filteredFlights.size()));
            filterFlights.setText(" " + getResources().getString(R.string.flight_lc));
        } else {
            filterResults.setText(String.valueOf(filteredFlights.size()));
            filterFlights.setText(" " + getResources().getString(R.string.flights_lc));
        }
    }

    private void initiateAdapter(ArrayList<SingleFlight> list) {
        mAdapter = new FlightsAdapter(flights.sort(flights.getOutboundFlights()));
        recyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.sort_layout)
    public void OnClickSort() {
        Intent myIntent = new Intent(getActivity(), SortActivity.class);
        //startActivityForResult(myIntent , REQUEST_CODE);
        getActivity().startActivity(myIntent);
    }

    @OnClick(R.id.filter_layout)
    public void OnClickFilter() {
        Intent myIntent = new Intent(getActivity(), FilterActivity.class);
        myIntent.putExtra("morning", String.valueOf(morningCheck));
        myIntent.putExtra("afternoon", String.valueOf(afternoonCheck));
        myIntent.putExtra("evening", String.valueOf(eveningCheck));
        myIntent.putExtra("lateNight", String.valueOf(lateNightCheck));
        myIntent.putExtra("straight", String.valueOf(straightFlightCheck));
        myIntent.putExtra("oneStop", String.valueOf(oneStopCheck));
        startActivityForResult(myIntent , REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_CODE  && resultCode  == RESULT_OK) {

                morningCheck = data.getStringExtra("morning");
                afternoonCheck = data.getStringExtra("afternoon");
                eveningCheck = data.getStringExtra("evening");
                lateNightCheck = data.getStringExtra("lateNight");
                straightFlightCheck = data.getStringExtra("straight");
                oneStopCheck = data.getStringExtra("oneStop");
                isClean = data.getStringExtra("isClean");
            }
        } catch (Exception ex) {
            Toast.makeText(getActivity(), ex.toString(),
                    Toast.LENGTH_SHORT).show();
        }

    }

}