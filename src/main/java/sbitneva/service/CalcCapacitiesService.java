package sbitneva.service;

import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.airline.Airline;

import java.util.ArrayList;

public class CalcCapacitiesService {
    private static CalcCapacitiesService service = new CalcCapacitiesService();

    private CalcCapacitiesService() {

    }

    public static CalcCapacitiesService getService() {
        return service;
    }

    public void calc() {
        Airline airline = Airline.getAirline();
        ArrayList<Aircraft> aircrafts = airline.getAircrafts();
        int totalCapacity = 0;
        int carriageCapacity = 0;
        for (Aircraft aircraft : aircrafts) {
            totalCapacity += aircraft.getCapacity();
            carriageCapacity += aircraft.getCarriageCapacity();
        }
        airline.setTotalCapacity(totalCapacity);
        airline.setCarriageCapacity(carriageCapacity);

    }
}
