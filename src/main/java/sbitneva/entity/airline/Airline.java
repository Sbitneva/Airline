package sbitneva.entity.airline;

import sbitneva.entity.aircrafts.Aircraft;

import java.util.ArrayList;
import java.util.Arrays;

public class Airline {

    private static Airline airline = new Airline();
    private ArrayList<Aircraft> aircrafts = new ArrayList<>();

    private Airline() {

    }

    public static Airline getAirline() {
        return airline;
    }

    public ArrayList<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(ArrayList<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    @Override
    public String toString(){
        StringBuffer s = new StringBuffer();
        for(Aircraft aircraft : aircrafts) {
            s.append(aircraft.toString());
        }
        return s.toString();
    }
}
