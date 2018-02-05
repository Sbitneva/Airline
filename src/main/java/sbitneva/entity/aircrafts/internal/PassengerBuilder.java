package sbitneva.entity.aircrafts.internal;

public class PassengerBuilder {
    private String firstName;
    private String lastName;
    private int luggageWeight;

    public PassengerBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PassengerBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PassengerBuilder setLuggageWeight(int luggageWeight) {
        this.luggageWeight = luggageWeight;
        return this;
    }

    public Passenger createPassenger() {
        return new Passenger(firstName, lastName, luggageWeight);
    }
}
