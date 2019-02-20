package com.example.mguimaraes.maxmilhas.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mguimaraes.maxmilhas.Fragments.InboundFragment;
import com.example.mguimaraes.maxmilhas.Fragments.OutboundFragment;
import com.example.mguimaraes.maxmilhas.Models.SingleFlight;
import com.example.mguimaraes.maxmilhas.R;

import java.util.ArrayList;

public class FlightsAdapter extends RecyclerView.Adapter<FlightsAdapter.MyViewHolder> {

    private ArrayList<SingleFlight> flights;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView originAirport;
        public TextView destinationAirport;
        public TextView timeDeparture;
        public TextView timeArrival;
        public TextView duration;
        public TextView numberStops;
        public TextView price;
        public TextView currency;

        public MyViewHolder(View view) {
            super(view);
            originAirport = (TextView) view.findViewById(R.id.origin_airport);
            destinationAirport = (TextView) view.findViewById(R.id.destination_airport);
            timeDeparture = (TextView) view.findViewById(R.id.time_departure);
            timeArrival = (TextView) view.findViewById(R.id.time_arrival);
            duration = (TextView) view.findViewById(R.id.duration);
            numberStops = (TextView) view.findViewById(R.id.number_stops);
            price = (TextView) view.findViewById(R.id.price);
            currency = (TextView) view.findViewById(R.id.currency);
        }
    }


    public FlightsAdapter(ArrayList<SingleFlight> flights) {
        this.flights = flights;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final SingleFlight flight = flights.get(position);

        if (flight.getTrips().size() > 1) {
            holder.numberStops.setText(String.valueOf(flight.getTrips().size()-1) + " paradas");
        } else {
            holder.numberStops.setText(String.valueOf(flight.getTrips().size()-1) + " parada");
        }

        if (flight.getDepartureDate().getMinutes() == 0) {
            holder.timeDeparture.setText(flight.getDepartureDate().getHours() + ":00");
        } else {
            holder.timeDeparture.setText(flight.getDepartureDate().getHours() + ":" + flight.getDepartureDate().getMinutes());
        }
        if (flight.getArrivalDate().getMinutes() == 0) {
            holder.timeArrival.setText(flight.getDepartureDate().getHours() + ":00");
        } else {
            holder.timeArrival.setText(flight.getDepartureDate().getHours() + ":" + flight.getDepartureDate().getMinutes());
        }
        holder.originAirport.setText(flight.getFrom());
        holder.destinationAirport.setText(flight.getTo());

        if (flight.getPricing().getOta() != null) {
            holder.price.setText("R$ " + flight.getPricing().getOta().getSaleTotal());
            holder.currency.setVisibility(View.VISIBLE);
        } else {
            holder.price.setText(R.string.not_available);
            holder.currency.setVisibility(View.INVISIBLE);
        }
        holder.duration.setText(getDuration(flight.getDuration()) + ", ");

    }

    @Override
    public int getItemCount() {
        return flights.size();
    }

    private String getDuration(int duration) {

        if (duration/60 == 0) {
            return String.valueOf(duration) + "min";
        } else {
            return String.valueOf(duration/60)+ "h"+String.valueOf(duration%60);
        }
    }
}
