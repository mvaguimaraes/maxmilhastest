package com.example.mguimaraes.maxmilhas.Models;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class FlightsTest {

    @Test
    public void testSortMethod_withValidInputInRandomOrder_shouldReturnSortedList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        flightsList.add(new SingleFlight(new Pricing(new Ota(1234.54))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(12.90))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(234.54))));
        Flights flights = new Flights(flightsList, null);

        assertEquals(12.90, flights.sort(flightsList).get(0).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(234.54, flights.sort(flightsList).get(1).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(1234.54, flights.sort(flightsList).get(2).getPricing().getOta().getSaleTotal(), 0.01);
    }

    @Test
    public void testSortMethod_withValidInputInAscendingOrder_shouldReturnSameList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        flightsList.add(new SingleFlight(new Pricing(new Ota(12.90))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(234.54))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(1234.54))));
        Flights flights = new Flights(flightsList, null);

        assertEquals(12.90, flights.sort(flightsList).get(0).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(234.54, flights.sort(flightsList).get(1).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(1234.54, flights.sort(flightsList).get(2).getPricing().getOta().getSaleTotal(), 0.01);
    }

    @Test
    public void testSortMethod_withValidInputInDescendingOrder_shouldReturnInverseList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        flightsList.add(new SingleFlight(new Pricing(new Ota(1234.54))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(234.54))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(12.90))));
        Flights flights = new Flights(flightsList, null);

        assertEquals(12.90, flights.sort(flightsList).get(0).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(234.54, flights.sort(flightsList).get(1).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(1234.54, flights.sort(flightsList).get(2).getPricing().getOta().getSaleTotal(), 0.01);
    }

    @Test
    public void testSortMethod_withEmptyList_shouldReturnEmptyList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        Flights flights = new Flights(flightsList, null);

        assertEquals(flights.sort(flightsList).size(), 0);
    }

    @Test
    public void testSortMethod_withNullInput_shouldReturnNull () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        Flights flights = new Flights(flightsList, null);

        assertEquals(flights.sort(null), null);
    }

    @Test
    public void testReverseSortMethod_withValidInputInRandomOrder_shouldReturnReverseSortedList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        flightsList.add(new SingleFlight(new Pricing(new Ota(1234.54))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(12.90))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(234.54))));
        Flights flights = new Flights(flightsList, null);

        assertEquals(1234.54, flights.sortReverse(flightsList).get(0).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(234.54, flights.sortReverse(flightsList).get(1).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(12.90, flights.sortReverse(flightsList).get(2).getPricing().getOta().getSaleTotal(), 0.01);
    }

    @Test
    public void testReverseSortMethod_withValidInputInAscendingOrder_shouldReturnReverseList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        flightsList.add(new SingleFlight(new Pricing(new Ota(12.90))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(234.54))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(1234.54))));
        Flights flights = new Flights(flightsList, null);

        assertEquals(1234.54, flights.sortReverse(flightsList).get(0).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(234.54, flights.sortReverse(flightsList).get(1).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(12.90, flights.sortReverse(flightsList).get(2).getPricing().getOta().getSaleTotal(), 0.01);
    }

    @Test
    public void testReverseSortMethod_withValidInputInDescendingOrder_shouldReturnSameList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        flightsList.add(new SingleFlight(new Pricing(new Ota(1234.54))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(234.54))));
        flightsList.add(new SingleFlight(new Pricing(new Ota(12.90))));
        Flights flights = new Flights(flightsList, null);

        assertEquals(1234.54, flights.sortReverse(flightsList).get(0).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(234.54, flights.sortReverse(flightsList).get(1).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(12.90, flights.sortReverse(flightsList).get(2).getPricing().getOta().getSaleTotal(), 0.01);
    }

    @Test
    public void testReverseSortMethod_withEmptyList_shouldReturnEmptyList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        Flights flights = new Flights(flightsList, null);

        assertEquals(flights.sortReverse(flightsList).size(), 0);
    }

    @Test
    public void testReverseSortMethod_withNullInput_shouldReturnNull () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        Flights flights = new Flights(flightsList, null);

        assertEquals(flights.sortReverse(null), null);
    }

    @Test
    public void testSortByTimeAndPriceMethod_withValidInputInRandomOrder_shouldReturnSortedList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        flightsList.add(new SingleFlight(50, new Pricing(new Ota(1234.54))));
        flightsList.add(new SingleFlight(10, new Pricing(new Ota(12.90))));
        flightsList.add(new SingleFlight(40, new Pricing(new Ota(234.54))));
        Flights flights = new Flights(flightsList, null);

        assertEquals(12.90, flights.sortByPriceAndTime(flightsList).get(0).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(234.54, flights.sortByPriceAndTime(flightsList).get(1).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(1234.54, flights.sortByPriceAndTime(flightsList).get(2).getPricing().getOta().getSaleTotal(), 0.01);
    }

    @Test
    public void testSortByTimeAndPriceMethod_withValidInputInAscendingOrder_shouldReturnSameList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        flightsList.add(new SingleFlight(10, new Pricing(new Ota(12.90))));
        flightsList.add(new SingleFlight(40, new Pricing(new Ota(234.54))));
        flightsList.add(new SingleFlight(50, new Pricing(new Ota(1234.54))));
        Flights flights = new Flights(flightsList, null);

        assertEquals(12.90, flights.sortByPriceAndTime(flightsList).get(0).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(234.54, flights.sortByPriceAndTime(flightsList).get(1).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(1234.54, flights.sortByPriceAndTime(flightsList).get(2).getPricing().getOta().getSaleTotal(), 0.01);
    }

    @Test
    public void testSortByTimeAndPriceMethod_withValidInputInDescendingOrder_shouldReturnInverseList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        flightsList.add(new SingleFlight(50, new Pricing(new Ota(1234.54))));
        flightsList.add(new SingleFlight(40, new Pricing(new Ota(234.54))));
        flightsList.add(new SingleFlight(10, new Pricing(new Ota(12.90))));
        Flights flights = new Flights(flightsList, null);

        assertEquals(12.90, flights.sortByPriceAndTime(flightsList).get(0).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(234.54, flights.sortByPriceAndTime(flightsList).get(1).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(1234.54, flights.sortByPriceAndTime(flightsList).get(2).getPricing().getOta().getSaleTotal(), 0.01);
    }

    @Test
    public void testSortByTimeAndPriceMethod_withEmptyList_shouldReturnEmptyList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        Flights flights = new Flights(flightsList, null);

        assertEquals(flights.sortByPriceAndTime(flightsList).size(), 0);
    }

    @Test
    public void testSortByTimeAndPriceMethod_withNullInput_shouldReturnNull () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        Flights flights = new Flights(flightsList, null);

        assertEquals(flights.sortByPriceAndTime(null), null);
    }

    @Test
    public void testSortByTimeAndPriceMethod_withValidInputAndATie_shouldResolveTheTieBySortingByDuration () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        flightsList.add(new SingleFlight(50, new Pricing(new Ota(1234.54))));
        flightsList.add(new SingleFlight(40, new Pricing(new Ota(1234.54))));
        flightsList.add(new SingleFlight(10, new Pricing(new Ota(12.90))));
        Flights flights = new Flights(flightsList, null);

        assertEquals(12.90, flights.sortByPriceAndTime(flightsList).get(0).getPricing().getOta().getSaleTotal(), 0.01);
        assertEquals(40, flights.sortByPriceAndTime(flightsList).get(1).getDuration(), 0.01);
        assertEquals(50, flights.sortByPriceAndTime(flightsList).get(2).getDuration(), 0.01);
    }

    @Test
    public void testFilter_with3StraightTrips_shouldReturnListWith3Elements () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        flightsList.add(new SingleFlight(trips, new Date()));
        flightsList.add(new SingleFlight(trips, new Date()));
        flightsList.add(new SingleFlight(trips, new Date()));
        Flights flights = new Flights(flightsList, null);

        assertEquals(3, flights.filterFlights(flightsList, true, false, false, true, true, true).size());
    }

    @Test
    public void testFilter_with2StraightTrips_shouldReturnListWith2Elements () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        flightsList.add(new SingleFlight(trips, new Date()));
        flightsList.add(new SingleFlight(trips, new Date()));
        ArrayList<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip());
        trips2.add(new Trip());
        flightsList.add(new SingleFlight(trips2, new Date()));
        Flights flights = new Flights(flightsList, null);

        assertEquals(2, flights.filterFlights(flightsList, true, false, false, false, false, false).size());
    }

    @Test
    public void testFilter_with1StraightTrip_shouldReturnListWith1Element () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        ArrayList<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip());
        trips2.add(new Trip());
        flightsList.add(new SingleFlight(trips, new Date()));
        flightsList.add(new SingleFlight(trips2, new Date()));
        flightsList.add(new SingleFlight(trips2, new Date()));
        Flights flights = new Flights(flightsList, null);

        assertEquals(1, flights.filterFlights(flightsList, true, false, false, false, false, false).size());
    }

    @Test
    public void testFilter_with3OneStopTrips_shouldReturnListWith3Elements () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        trips.add(new Trip());
        flightsList.add(new SingleFlight(trips, new Date()));
        flightsList.add(new SingleFlight(trips, new Date()));
        flightsList.add(new SingleFlight(trips, new Date()));
        Flights flights = new Flights(flightsList, null);

        assertEquals(3, flights.filterFlights(flightsList, true, false, false, true, true, true).size());
    }

    @Test
    public void testFilter_with1OneStopTrip_shouldReturnListWith1Element () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        flightsList.add(new SingleFlight(trips, new Date()));
        flightsList.add(new SingleFlight(trips, new Date()));
        ArrayList<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip());
        trips2.add(new Trip());
        flightsList.add(new SingleFlight(trips2, new Date()));
        Flights flights = new Flights(flightsList, null);

        assertEquals(1, flights.filterFlights(flightsList, false, true, false, false, false, false).size());
    }

    @Test
    public void testFilter_with2OneStopTrip_shouldReturnListWith2Elements () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        ArrayList<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip());
        trips2.add(new Trip());
        flightsList.add(new SingleFlight(trips, new Date()));
        flightsList.add(new SingleFlight(trips2, new Date()));
        flightsList.add(new SingleFlight(trips2, new Date()));
        Flights flights = new Flights(flightsList, null);

        assertEquals(2, flights.filterFlights(flightsList, false, true, false, false, false, false).size());
    }

    @Test
    public void testFilter_with3miscTrips_shouldReturnListWith3Elements () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        ArrayList<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip());
        trips2.add(new Trip());
        flightsList.add(new SingleFlight(trips, new Date()));
        flightsList.add(new SingleFlight(trips2, new Date()));
        flightsList.add(new SingleFlight(trips2, new Date()));
        Flights flights = new Flights(flightsList, null);

        assertEquals(3, flights.filterFlights(flightsList, true, true, false, false, false, false).size());
    }

    @Test
    public void testFilter_with1TripInTheTimeSlot_shouldReturnListWith1Elements () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        ArrayList<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip());
        trips2.add(new Trip());
        Date date = new Date();
        String string = "22/02/2019 07:40:00";
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        flightsList.add(new SingleFlight(trips, date));
        flightsList.add(new SingleFlight(trips2, new Date()));
        flightsList.add(new SingleFlight(trips2, new Date()));
        Flights flights = new Flights(flightsList, null);

        assertEquals(1, flights.filterFlights(flightsList, false, false, true, false, false, false).size());
    }

    @Test
    public void testFilter_with2TripInTheTimeSlot_shouldReturnListWith2Elements () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        ArrayList<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip());
        trips2.add(new Trip());
        Date date = new Date();
        String string = "22/02/2019 07:40:00";
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        flightsList.add(new SingleFlight(trips, date));
        flightsList.add(new SingleFlight(trips2, date));
        Flights flights = new Flights(flightsList, null);

        assertEquals(2, flights.filterFlights(flightsList, false, false, true, false, false, false).size());
    }

    @Test
    public void testFilter_withTripsIn2DifferentTimeSlots_shouldReturnListWith2Elements () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        ArrayList<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip());
        trips2.add(new Trip());
        Date date = new Date();
        String string = "22/02/2019 07:40:00";
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = new Date();
        String string2 = "22/02/2019 13:40:00";
        DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            date2 = format2.parse(string2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        flightsList.add(new SingleFlight(trips, date));
        flightsList.add(new SingleFlight(trips2, date2));
        Flights flights = new Flights(flightsList, null);

        assertEquals(2, flights.filterFlights(flightsList, false, false, true, true, false, false).size());
    }

    @Test
    public void testFilter_withTripsIn3DifferentTimeSlots_shouldReturnListWith3Elements () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        ArrayList<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip());
        trips2.add(new Trip());
        Date date = new Date();
        String string = "22/02/2019 07:40:00";
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = new Date();
        String string2 = "22/02/2019 13:40:00";
        DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            date2 = format2.parse(string2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date3 = new Date();
        String string3 = "22/02/2019 19:40:00";
        DateFormat format3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            date3 = format3.parse(string3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        flightsList.add(new SingleFlight(trips, date));
        flightsList.add(new SingleFlight(trips2, date2));
        flightsList.add(new SingleFlight(trips2, date3));
        Flights flights = new Flights(flightsList, null);

        assertEquals(3, flights.filterFlights(flightsList, false, false, true, true, true, false).size());
    }

    @Test
    public void testFilter_withTripsIn4DifferentTimeSlots_shouldReturnListWith4Elements () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        ArrayList<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip());
        trips2.add(new Trip());
        Date date = new Date();
        String string = "22/02/2019 07:40:00";
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = new Date();
        String string2 = "22/02/2019 13:40:00";
        DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            date2 = format2.parse(string2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date3 = new Date();
        String string3 = "22/02/2019 19:40:00";
        DateFormat format3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            date3 = format3.parse(string3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date4 = new Date();
        String string4 = "22/02/2019 01:40:00";
        DateFormat format4 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            date4 = format4.parse(string4);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        flightsList.add(new SingleFlight(trips, date));
        flightsList.add(new SingleFlight(trips2, date2));
        flightsList.add(new SingleFlight(trips2, date3));
        flightsList.add(new SingleFlight(trips2, date4));
        Flights flights = new Flights(flightsList, null);

        assertEquals(3, flights.filterFlights(flightsList, false, false, true, true, true, false).size());
    }

    @Test
    public void testFilter_withNoStraightTrip_shouldReturnEmptyList () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        ArrayList<Trip> trips2 = new ArrayList<>();
        trips2.add(new Trip());
        trips2.add(new Trip());
        flightsList.add(new SingleFlight(trips2, new Date()));
        flightsList.add(new SingleFlight(trips2, new Date()));
        flightsList.add(new SingleFlight(trips2, new Date()));
        Flights flights = new Flights(flightsList, null);

        assertEquals(0, flights.filterFlights(flightsList, true, false, false, false, false, false).size());
    }

    @Test
    public void testFilter_withNullInput_shouldReturnNull () {
        ArrayList<SingleFlight> flightsList = new ArrayList<>();
        Flights flights = new Flights(flightsList, null);

        assertEquals(null, flights.filterFlights(null, true, false, false, false, false, false));
    }
}