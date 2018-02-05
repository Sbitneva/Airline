package sbitneva.entity.aircrafts.internal;

public class Passenger {

    private String firstName;
    private String lastName;
    private int luggageWeight;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(int luggageWeight) {
        this.luggageWeight = luggageWeight;
    }
}
