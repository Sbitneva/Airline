package sbitneva.entity.aircrafts;

import sbitneva.entity.aircrafts.internal.Passenger;

import java.util.ArrayList;

public class PassengerHelicopter extends Helicopter implements Passengers {

    private ArrayList<Passenger> passengersList = new ArrayList<>();

    @Override
    public void addPassenger(Passenger passenger) {
        passengersList.add(passenger);
    }

    @Override
    public ArrayList<Passenger> getPassengersList() {
        return passengersList;
    }

    @Override
    public void setPassengersList(ArrayList<Passenger> passengers) {
        passengersList = passengers;
    }

    @Override
    public int getCarriageCapacity() {
        int carriageCapacity = 0;
        for (Passenger passenger : passengersList) {
            carriageCapacity += passenger.getLuggageWeight();
        }
        this.setCarriageCapacity(carriageCapacity);
        return carriageCapacity;
    }
}
