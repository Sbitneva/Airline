import org.junit.Test;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.aircrafts.AircraftBuilder;
import sbitneva.entity.aircrafts.CargosHelicopter;
import sbitneva.entity.aircrafts.PassengerAirplane;
import sbitneva.entity.airline.Airline;
import sbitneva.service.FindByFuelRangeService;

import java.util.ArrayList;

public class FindByFuelRangeServiceTest {
    private Airline airline = Airline.getAirline();

    @Test
    public void findTest() {

        airline.clean();

        PassengerAirplane passengerAirplane = new AircraftBuilder().setFuelConsumption(1000).createPassengerAirplane();

        CargosHelicopter cargosHelicopter = new AircraftBuilder().setFuelConsumption(600).createCargosHelicopter();


        airline.addAircraft(passengerAirplane);
        airline.addAircraft(cargosHelicopter);
        FindByFuelRangeService service = FindByFuelRangeService.getService();
        service.find(500, 1000);

    }
}
