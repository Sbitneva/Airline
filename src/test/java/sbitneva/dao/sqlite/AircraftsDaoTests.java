package sbitneva.dao.sqlite;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sbitneva.config.TestConfiguration;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.aircrafts.PassengerAirplane;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)

public class AircraftsDaoTests {

    private static Logger log = Logger.getLogger(AircraftsDaoTests.class.getName());

    @Mock
    @Autowired
    private DataSource dataSource;

    @InjectMocks
    @Autowired
    private AircraftsDao aircraftsDao;

    @Before
    public void setUp() {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("restore from airline_test.db");
        } catch (SQLException e) {
            log.error(e.getClass() + " : " + e.getMessage());
        }
    }


    @Test
    public void readTest() {
        Aircraft aircraft = aircraftsDao.read(1);
        assertEquals(aircraft.getClass().getSimpleName(), "CargosHelicopter");
        assertEquals(2, aircraft.getTypeId());
        assertEquals(aircraft.getName(), "Volchara");
        assertEquals(aircraft.getFlightRange(), 5000);
    }

    @Test
    public void deleteTest() {
        ArrayList<Aircraft> aircrafts = aircraftsDao.readAllAircrafts();
        assertEquals(aircrafts.size(), 4);
        aircraftsDao.delete(1);
        aircrafts = aircraftsDao.readAllAircrafts();
        assertEquals(aircrafts.size(), 3);

    }

    @Test
    public void updateTest() {

    }

    @Test
    public void createTest() {
        ArrayList<Aircraft> aircrafts = aircraftsDao.readAllAircrafts();
        assertEquals(aircrafts.size(), 4);

        Aircraft aircraft = new PassengerAirplane();
        aircraft.setTypeId(1);
        aircraft.setCarriageCapacity(5000);
        aircraft.setFuelConsumption(6000);
        aircraft.setFlightRange(2000);
        aircraft.setName("OREL");

        aircraftsDao.create(aircraft);

        aircrafts = aircraftsDao.readAllAircrafts();
        assertEquals(aircrafts.size(), 5);
        Aircraft aircraft1 = aircraftsDao.read(5);
        assertEquals(aircraft1.getName(), "OREL");
        assertEquals(aircraft1.getTypeId(), 1);
    }

    @Test
    public void readAllTest() {
        ArrayList<Aircraft> aircrafts = aircraftsDao.readAllAircrafts();
        assertEquals(aircrafts.size(), 4);

    }
}
