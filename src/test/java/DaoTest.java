import org.junit.Test;
import sbitneva.dao.AirlineDao;
import sbitneva.dao.AirlineDaoFactory;
import sbitneva.entity.airline.Airline;

import static org.junit.Assert.assertEquals;

public class DaoTest {

    private Airline airline = Airline.getAirline();

    @Test
    public void testXmlDao(){
        airline.clean();

        AirlineDao xmlDao = AirlineDaoFactory.getAirlineXmlDaoParam("xml_test/airline.xsd",
                "xml_test/airline.xml");
        xmlDao.loadAircrafts();

        assertEquals(15, airline.getAircrafts().size());

    }
}
