package sbitneva.entity.aircrafts;

public class AircraftFactory {

    private static final String CARGO_HELICOPTER = "cargo_helicopter";
    private static final String CARGO_AIRPLANE = "cargo_airplane";

    private static final String PASS_HELICOPTER = "passenger_helicopter";
    private static final String PASS_AIRPLANE = "passenger_airplane";


    public static Aircraft getAircraft(String type) {
        Aircraft aircraft = null;
        switch (type) {
            case CARGO_HELICOPTER:
                aircraft = new CargosHelicopter();
                break;
            case CARGO_AIRPLANE:
                aircraft = new CargosAirplane();
                break;
            case PASS_AIRPLANE:
                aircraft = new PassengerAirplane();
                break;
            case PASS_HELICOPTER:
                aircraft = new PassengerHelicopter();
                break;
        }
        return aircraft;
    }
}
