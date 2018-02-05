package sbitneva.entity.aircrafts;

public class Aircraft {

    private String id;
    private String name;
    private int capacity;
    private int flightRange;
    private int fuelConsumption;
    private int carriageCapacity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsuption) {
        this.fuelConsumption = fuelConsuption;
    }

    public int getCarriageCapacity() {
        return carriageCapacity;
    }

    public void setCarriageCapacity(int carriageCapacity) {
        this.carriageCapacity = carriageCapacity;
    }

    @Override
    public String toString() {
        return "\nAircraft {" +
                "id = '" + id + " \t" +
                ", name= '" + name + "," +
                " \t flightRange= " + flightRange +  "," +
                " \t fuelConsumption= " + fuelConsumption +
                " }";
    }
}
