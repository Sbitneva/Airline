package sbitneva.entity.aircrafts;

public class Helicopter extends Aircraft {

    public Helicopter() {
        super();
    }

    public Helicopter(String id, String name, int capacity, int flightRange, int fuelConsumption, int carriageCapacity) {
        super(id, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }
}
