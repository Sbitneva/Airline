package sbitneva.dao;

public class AirlineDaoFactory {

    private static AirlineDaoFactory airlineDaoFactory = new AirlineDaoFactory();
    private static AirlineXmlDao airlineXmlDao = new AirlineXmlDao();


    private AirlineDaoFactory() {

    }

    public static AirlineDaoFactory getAirlineDaoFactory() {
        return airlineDaoFactory;
    }

    public static AirlineXmlDao getAirlineXmlDao() {
        return airlineXmlDao;
    }

    public static AirlineXmlDao getAirlineXmlDaoParam(String schemaPath, String dataPath) {
        return new AirlineXmlDao(schemaPath, dataPath);
    }
}
