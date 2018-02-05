package sbitneva.service;

import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.airline.Airline;
import sbitneva.menu.Menu;

import java.util.ArrayList;

public class FindByFuelRangeService {

    private static FindByFuelRangeService service = new FindByFuelRangeService();

    private FindByFuelRangeService(){

    }

    public static FindByFuelRangeService getService() {
        return service;
    }

    public void find(int min, int max) {
        Airline airline = Airline.getAirline();
        ArrayList<Aircraft> aircrafts = airline.getAircrafts();
        System.out.println("Aircrafts in given fuel consumption range " + min + ".." + max + ":");
        for(Aircraft aircraft : aircrafts) {
            int fuelConsumption = aircraft.getFuelConsumption();
            if((fuelConsumption >= min) && (fuelConsumption <= max)) {
                System.out.println(aircraft);
            }
        }
        System.out.println("\n" + Menu.actions);
    }
}
