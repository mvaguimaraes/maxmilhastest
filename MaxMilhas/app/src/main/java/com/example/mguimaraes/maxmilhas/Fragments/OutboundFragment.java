package com.example.mguimaraes.maxmilhas.Fragments;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.example.mguimaraes.maxmilhas.Utilities.Utilities;

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

    public static final int REQUEST_CODE_FILTER = 1;
    public static final int REQUEST_CODE_SORT = 2;

    @BindView(R.id.with_filter)
    TextView withFilter;
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
    @BindView(R.id.emptyView)
    RelativeLayout emptyView;
    @BindView(R.id.no_internet_view)
    RelativeLayout noInternetView;
    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swipe;
    private Flights flights = new Flights(new ArrayList<>(), new ArrayList<>());
    private ArrayList<SingleFlight> filteredFlights = new ArrayList<>();
    private FlightsAdapter mAdapter;
    public static String morningCheck = "false", afternoonCheck = "false", eveningCheck = "false", lateNightCheck = "false", straightFlightCheck = "false", oneStopCheck = "false", isClean = "false", radioOption = "1";
    public static Boolean comingFromHere = false;
    public static int qtMorning, qtAfternoon, qtEvening, qtLateNight, qtStraight, qtOneStop;
    private ProgressDialog pd = null;

    public OutboundFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
        pd = new ProgressDialog(getActivity());
        if (Utilities.isNetworkAvailable(getActivity())) {
            noInternetView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            withFilter.setVisibility(View.VISIBLE);
            filterResults.setVisibility(View.VISIBLE);
            pd.setMessage(getResources().getString(R.string.progress_dialog_loading));
            pd.show();
            getFlights();
        } else {
            recyclerView.setVisibility(View.GONE);
            withFilter.setVisibility(View.GONE);
            filterResults.setVisibility(View.GONE);
            noInternetView.setVisibility(View.VISIBLE);
        }
        swipe.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        getFlights();
                    }
                }
        );
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
                initiateAdapter(filteredFlights, radioOption);
                pd.cancel();
                swipe.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<Flights>call, Throwable t) {
                // Log error here since request failed
                recyclerView.setVisibility(View.GONE);
                withFilter.setVisibility(View.GONE);
                filterResults.setVisibility(View.GONE);
                noInternetView.setVisibility(View.VISIBLE);
                pd.cancel();
                swipe.setRefreshing(false);
            }
        });
    }

    private void setFilterTexts(int qty) {
        filterResults.setVisibility(View.VISIBLE);
        withFilter.setVisibility(View.VISIBLE);
        if (qty == 1) {
            filterResults.setText(String.valueOf(filteredFlights.size()));
            filterFlights.setText(" " + getResources().getString(R.string.flight_lc));
        } else {
            filterResults.setText(String.valueOf(filteredFlights.size()));
            filterFlights.setText(" " + getResources().getString(R.string.flights_lc));
        }
    }

    private void initiateAdapter(ArrayList<SingleFlight> list, String sortingOption) {
        if (list.size() == 0) {
            emptyView.setVisibility(View.VISIBLE);
            withFilter.setVisibility(View.VISIBLE);
            filterResults.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            noInternetView.setVisibility(View.GONE);
        } else {
            switch (sortingOption) {
                case "0":
                    mAdapter = new FlightsAdapter(flights.sortReverse(list));
                    break;
                case "1":
                    mAdapter = new FlightsAdapter(flights.sort(list));
                    break;
                case "2":
                    mAdapter = new FlightsAdapter(flights.sortByPriceAndTime(list));
                    break;
            }
            recyclerView.setAdapter(mAdapter);
            emptyView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.sort_layout)
    public void OnClickSort() {
        if (Utilities.isNetworkAvailable(getActivity())) {
            Intent myIntent = new Intent(getActivity(), SortActivity.class);
            startActivityForResult(myIntent, REQUEST_CODE_SORT);
        }
    }

    @OnClick(R.id.filter_layout)
    public void OnClickFilter() {
        if (Utilities.isNetworkAvailable(getActivity())) {
            Intent myIntent = new Intent(getActivity(), FilterActivity.class);
            qtStraight = flights.filterFlights(flights.getOutboundFlights(), true, false, false, false, false, false).size();
            qtOneStop = flights.filterFlights(flights.getOutboundFlights(), false, true, false, false, false, false).size();
            qtMorning = flights.filterFlights(flights.getOutboundFlights(), false, false, true, false, false, false).size();
            qtAfternoon = flights.filterFlights(flights.getOutboundFlights(), false, false, false, true, false, false).size();
            qtEvening = flights.filterFlights(flights.getOutboundFlights(), false, false, false, false, true, false).size();
            qtLateNight = flights.filterFlights(flights.getOutboundFlights(), false, false, false, false, false, true).size();
            myIntent.putExtra("morning", String.valueOf(morningCheck));
            myIntent.putExtra("afternoon", String.valueOf(afternoonCheck));
            myIntent.putExtra("evening", String.valueOf(eveningCheck));
            myIntent.putExtra("lateNight", String.valueOf(lateNightCheck));
            myIntent.putExtra("straight", String.valueOf(straightFlightCheck));
            myIntent.putExtra("oneStop", String.valueOf(oneStopCheck));
            comingFromHere = true;
            startActivityForResult(myIntent, REQUEST_CODE_FILTER);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_CODE_FILTER  && resultCode  == RESULT_OK) {

                comingFromHere = false;
                morningCheck = data.getStringExtra("morning");
                afternoonCheck = data.getStringExtra("afternoon");
                eveningCheck = data.getStringExtra("evening");
                lateNightCheck = data.getStringExtra("lateNight");
                straightFlightCheck = data.getStringExtra("straight");
                oneStopCheck = data.getStringExtra("oneStop");
                isClean = data.getStringExtra("isClean");

                if (isClean.equals("true")) {
                    morningCheck = "false";
                    afternoonCheck = "false";
                    eveningCheck = "false";
                    lateNightCheck = "false";
                    straightFlightCheck = "false";
                    oneStopCheck = "false";
                    filteredFlights = flights.getOutboundFlights();
                    initiateAdapter(filteredFlights, radioOption);
                    setFilterResultsTextView(filteredFlights.size());
                } else {
                    filterFlights();
                }
            }
            if (requestCode == REQUEST_CODE_SORT  && resultCode  == RESULT_OK) {
                radioOption = data.getStringExtra("sortingOption");
                initiateAdapter(filteredFlights, radioOption);
            }
        } catch (Exception ex) {
            Toast.makeText(getActivity(), ex.toString(),
                    Toast.LENGTH_SHORT).show();
        }

    }

    private void filterFlights() {
        filteredFlights = flights.filterFlights(flights.getOutboundFlights(), Boolean.parseBoolean(straightFlightCheck), Boolean.parseBoolean(oneStopCheck), Boolean.parseBoolean(morningCheck), Boolean.parseBoolean(afternoonCheck), Boolean.parseBoolean(eveningCheck), Boolean.parseBoolean(lateNightCheck));
        setFilterResultsTextView(filteredFlights.size());
        initiateAdapter(filteredFlights, radioOption);
    }

    private void setFilterResultsTextView(int i) {
        filterResults.setText(Integer.toString(filteredFlights.size()));
        if (i == 1) {
            filterFlights.setText(" " + getActivity().getResources().getString(R.string.flight).toLowerCase());
        } else {
            filterFlights.setText(" " + getActivity().getResources().getString(R.string.flights).toLowerCase());
        }
    }
}