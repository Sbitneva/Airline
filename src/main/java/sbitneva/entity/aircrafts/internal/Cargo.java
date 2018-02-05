package sbitneva.entity.aircrafts.internal;

public class Cargo {

    private String id;
    private int cargoWeight;

    public Cargo() {

    }

    public Cargo(String id, int cargoWeight) {
        this.id = id;
        this.cargoWeight = cargoWeight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
}
