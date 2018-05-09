package sbitneva.entity.aircrafts;

public class AircraftBuilder {

    private String id;
    private String name;
    private int capacity;
    private int flightRange;
    private int fuelConsumption;
    private int carriageCapacity;

    public AircraftBuilder() {

    }


    public AircraftBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public AircraftBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AircraftBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public AircraftBuilder setFlightRange(int flightRange) {
        this.flightRange = flightRange;
        return this;
    }

    public AircraftBuilder setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public AircraftBuilder setCarriageCapacity(int carriageCapacity) {
        this.carriageCapacity = carriageCapacity;
        return this;
    }

    public PassengerAirplane createPassengerAirplane() {
        return new PassengerAirplane(id, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }

    public PassengerHelicopter createPassengerHelicopter() {
        return new PassengerHelicopter(id, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }

    public CargosHelicopter createCargosHelicopter() {
        return new CargosHelicopter(id, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }

    public CargosAirplane createCargosAirplane() {
        return new CargosAirplane(id, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }


}
