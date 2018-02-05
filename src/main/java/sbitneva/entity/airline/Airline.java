package sbitneva.entity.airline;

import sbitneva.entity.aircrafts.Aircraft;

import java.util.ArrayList;

public class Airline {

    private static Airline airline = new Airline();
    private ArrayList<Aircraft> aircrafts = new ArrayList<>();

    private int totalCapacity;
    private int carriageCapacity;

    private Airline() {

    }

    public static Airline getAirline() {
        return airline;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getCarriageCapacity() {
        return carriageCapacity;
    }

    public void setCarriageCapacity(int carriageCapacity) {
        this.carriageCapacity = carriageCapacity;
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

    public void clean(){
        this.aircrafts.clear();
        this.totalCapacity = 0;
        this.carriageCapacity = 0;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (Aircraft aircraft : aircrafts) {
            s.append(aircraft.toString());
        }
        return s.toString();
    }
}
