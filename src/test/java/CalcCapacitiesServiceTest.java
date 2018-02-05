import org.junit.Test;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.aircrafts.AircraftBuilder;
import sbitneva.entity.aircrafts.CargosHelicopter;
import sbitneva.entity.aircrafts.PassengerAirplane;
import sbitneva.entity.aircrafts.internal.CargoBuilder;
import sbitneva.entity.aircrafts.internal.PassengerBuilder;
import sbitneva.entity.airline.Airline;
import sbitneva.service.CalcCapacitiesService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CalcCapacitiesServiceTest {

    private Airline airline = Airline.getAirline();
    private CalcCapacitiesService service = CalcCapacitiesService.getService();

    @Test
    public void calcClearTest() {
        airline.clean();

        CalcCapacitiesService service = CalcCapacitiesService.getService();
        service.calc();

        assertEquals(0, airline.getCarriageCapacity());
        assertEquals(0, airline.getTotalCapacity());
    }

    @Test
    public void calcWithDataTest() {
        airline.clean();

        PassengerAirplane passengerAirplane = new AircraftBuilder().setCapacity(1000).createPassengerAirplane();
        passengerAirplane.addPassenger(new PassengerBuilder().setLuggageWeight(10).createPassenger());
        passengerAirplane.addPassenger(new PassengerBuilder().setLuggageWeight(10).createPassenger());
        CargosHelicopter cargosHelicopter = new AircraftBuilder().setCapacity(1000).createCargosHelicopter();
        cargosHelicopter.addCargo(new CargoBuilder().setCargoWeight(10).createCargo());
        cargosHelicopter.addCargo(new CargoBuilder().setCargoWeight(10).createCargo());

        airline.addAircraft(passengerAirplane);
        airline.addAircraft(cargosHelicopter);

        service.calc();

        assertEquals(40, airline.getCarriageCapacity());
        assertEquals(2000, airline.getTotalCapacity());
    }
}
