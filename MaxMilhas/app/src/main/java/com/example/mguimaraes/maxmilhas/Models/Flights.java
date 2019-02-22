package com.example.mguimaraes.maxmilhas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("serial")
public class Flights implements Serializable {

    @SerializedName("outbound")
    private ArrayList<SingleFlight> outboundFlights;
    @SerializedName("inbound")
    private ArrayList<SingleFlight> inboundFlights;

    public Flights() {}

    public Flights(ArrayList<SingleFlight> outboundFlights, ArrayList<SingleFlight> inboundFlights) {
        this.outboundFlights = outboundFlights;
        this.inboundFlights = inboundFlights;
    }

    public ArrayList<SingleFlight> getOutboundFlights() {
        return outboundFlights;
    }

    public void setOutboundFlights(ArrayList<SingleFlight> outboundFlights) {
        this.outboundFlights = outboundFlights;
    }

    public ArrayList<SingleFlight> getInboundFlights() {
        return inboundFlights;
    }

    public void setInboundFlights(ArrayList<SingleFlight> inboundFlights) {
        this.inboundFlights = inboundFlights;
    }

    public ArrayList<SingleFlight> sortReverse(ArrayList<SingleFlight> list) {
        if (list != null) {
            Collections.sort(list, new Comparator<SingleFlight>() {
                @Override
                public int compare(SingleFlight lhs, SingleFlight rhs) {
                    // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                    if (lhs.getPricing().getOta() == null || rhs.getPricing().getOta() == null) {
                        return 1;
                    } else {
                        return lhs.getPricing().getOta().getSaleTotal() > rhs.getPricing().getOta().getSaleTotal() ? -1 : (lhs.getPricing().getOta().getSaleTotal() < rhs.getPricing().getOta().getSaleTotal()) ? 1 : 0;
                    }
                }
            });

            return list;
        } else {
            return null;
        }
    }

    public ArrayList<SingleFlight> sort(ArrayList<SingleFlight> list) {
        if (list != null) {
            Collections.sort(list, new Comparator<SingleFlight>() {
                @Override
                public int compare(SingleFlight lhs, SingleFlight rhs) {
                    // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                    if (lhs.getPricing().getOta() == null || rhs.getPricing().getOta() == null) {
                        return 1;
                    } else {
                        return lhs.getPricing().getOta().getSaleTotal() > rhs.getPricing().getOta().getSaleTotal() ? 1 : (lhs.getPricing().getOta().getSaleTotal() < rhs.getPricing().getOta().getSaleTotal()) ? -1 : 0;
                    }
                }
            });

            return list;
        } else {
            return null;
        }
    }

    public ArrayList<SingleFlight> sortByPriceAndTime(ArrayList<SingleFlight> list) {

        if (list != null) {
            Collections.sort(list, new Comparator() {

                public int compare(Object o1, Object o2) {

                    if (((SingleFlight) o1).getPricing().getOta() != null && ((SingleFlight) o2).getPricing().getOta() != null) {

                        Double x1 = ((SingleFlight) o1).getPricing().getOta().getSaleTotal();
                        Double x2 = ((SingleFlight) o2).getPricing().getOta().getSaleTotal();
                        int sComp = x1.compareTo(x2);

                        if (sComp != 0) {
                            return sComp;
                        }
                    }

                    Integer y1 = ((SingleFlight) o1).getDuration();
                    Integer y2 = ((SingleFlight) o2).getDuration();
                    return y1.compareTo(y2);
                }
            });

            return list;
        } else {
            return null;
        }
    }

    public ArrayList<SingleFlight> filterFlights(ArrayList<SingleFlight> list, Boolean straight, Boolean oneStop, Boolean morning, Boolean afternoon, Boolean evening, Boolean lateNight) {

        if (list != null) {
            ArrayList<SingleFlight> result = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {

                if (straight) {
                    if (list.get(i).getTrips().size() == 1) {
                        result.add(list.get(i));
                        continue;
                    }
                }
                if (oneStop) {
                    if (list.get(i).getTrips().size() == 2) {
                        result.add(list.get(i));
                        continue;
                    }
                }
                if (morning) {
                    if (6 <= list.get(i).getDepartureDate().getHours() && 12 > list.get(i).getDepartureDate().getHours()) {
                        result.add(list.get(i));
                        continue;
                    }
                }
                if (afternoon) {
                    if (12 <= list.get(i).getDepartureDate().getHours() && 18 > list.get(i).getDepartureDate().getHours()) {
                        result.add(list.get(i));
                        continue;
                    }
                }
                if (evening) {
                    if (18 <= list.get(i).getDepartureDate().getHours() && 23 >= list.get(i).getDepartureDate().getHours()) {
                        result.add(list.get(i));
                        continue;
                    }
                }
                if (lateNight) {
                    if (0 <= list.get(i).getDepartureDate().getHours() && 6 > list.get(i).getDepartureDate().getHours()) {
                        result.add(list.get(i));
                        continue;
                    }
                }
                /*
                if (!straight) {
                    if (list.get(i).getTrips().size() == 1) {
                        continue;
                    }
                }
                if (!oneStop) {
                    if (list.get(i).getTrips().size() == 2) {
                        continue;
                    }
                }
                if (!morning) {
                    if (6 <= list.get(i).getDepartureDate().getHours() && 12 > list.get(i).getDepartureDate().getHours()) {
                        continue;
                    }
                }
                if (!afternoon) {
                    if (12 <= list.get(i).getDepartureDate().getHours() && 18 > list.get(i).getDepartureDate().getHours()) {
                        continue;
                    }
                }
                if (!evening) {
                    if (18 <= list.get(i).getDepartureDate().getHours() && 23 >= list.get(i).getDepartureDate().getHours()) {
                        continue;
                    }
                }
                if (!check5) {
                    if (0 <= list.get(i).getDepartureDate().getHours() && 6 > list.get(i).getDepartureDate().getHours()) {
                        continue;
                    }
                }
                result.add(list.get(i));*/
            }

            return result;
        } else {
            return null;
        }
    }

}
