package sbitneva.dao;

import sbitneva.dao.postgres.AircraftTypes;
import sbitneva.dao.postgres.AircraftsDao;
import sbitneva.dao.postgres.BaggageDao;
import sbitneva.dao.postgres.PassengersDao;

public class AirlineDaoFactory {

    private static AirlineDaoFactory airlineDaoFactory = new AirlineDaoFactory();

    private static AircraftsDao aircraftsDao = new AircraftsDao();
    private static AircraftTypes aircraftTypes = new AircraftTypes();
    private static BaggageDao baggageDao = new BaggageDao();
    private static PassengersDao passengersDao = new PassengersDao();

    private AirlineDaoFactory() {

    }

    public static AirlineDaoFactory getAirlineDaoFactory() {
        return airlineDaoFactory;
    }

    public static AircraftsDao getAircraftsDao() {
        return aircraftsDao;
    }

    public static AircraftTypes getAircraftTypes() {
        return aircraftTypes;
    }

    public static BaggageDao getBaggageDao() {
        return baggageDao;
    }

    public static PassengersDao getPassengersDao() {
        return passengersDao;
    }
}
