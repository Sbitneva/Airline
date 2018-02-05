package sbitneva.service;

import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.airline.Airline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByFlightRangeService {
    private static SortByFlightRangeService sortByFlightRangeService = new SortByFlightRangeService();

    private SortByFlightRangeService() {

    }

    public static SortByFlightRangeService getService() {
        return sortByFlightRangeService;
    }

    public void sort() {
        Airline airline = Airline.getAirline();
        ArrayList aircrafts = airline.getAircrafts();
        Collections.sort(aircrafts, new Comparator<Aircraft>() {
            public int compare(Aircraft aircraft1, Aircraft aircraft2) {
                return aircraft1.getFlightRange() - aircraft2.getFlightRange();
            }
        });
        System.out.println("Sorted aircrafts: ");
        System.out.println(airline.toString());
    }
}
