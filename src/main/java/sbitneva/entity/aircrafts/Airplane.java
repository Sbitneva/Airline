package sbitneva.entity.aircrafts;

public class Airplane extends Aircraft {

    public Airplane() {
        super();
    }

    public Airplane(int id, String name, int capacity, int flightRange, int fuelConsumption, int carriageCapacity) {
        super(id, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }
}
