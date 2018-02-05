import org.junit.Test;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.aircrafts.AircraftBuilder;
import sbitneva.entity.airline.Airline;
import sbitneva.service.SortByFlightRangeService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SortByFlightRangeServiceTest {

    private Airline airline = Airline.getAirline();
    private SortByFlightRangeService service = SortByFlightRangeService.getService();

    @Test
    public void sortTest() {
        airline.clean();
        airline.setAircrafts(new ArrayList<Aircraft>());

        airline.addAircraft(new AircraftBuilder().setFlightRange(8000).createPassengerAirplane());
        airline.addAircraft(new AircraftBuilder().setFlightRange(6000).createCargosHelicopter());
        airline.addAircraft(new AircraftBuilder().setFlightRange(2000).createCargosAirplane());

        assertEquals(8000, airline.getAircrafts().get(0).getFlightRange());
        assertEquals(6000, airline.getAircrafts().get(1).getFlightRange());
        assertEquals(2000, airline.getAircrafts().get(2).getFlightRange());

        service.sort();

        assertEquals(2000, airline.getAircrafts().get(0).getFlightRange());
        assertEquals(6000, airline.getAircrafts().get(1).getFlightRange());
        assertEquals(8000, airline.getAircrafts().get(2).getFlightRange());

    }
}
