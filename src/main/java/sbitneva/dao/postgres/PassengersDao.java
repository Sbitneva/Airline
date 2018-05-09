package sbitneva.dao.postgres;

import sbitneva.dao.CRUD;
import sbitneva.entity.aircrafts.internal.Passenger;

public class PassengersDao implements CRUD<Passenger> {

    private final static String CREATE_PASSENGER_REQUEST = "insert into passengers values (default, ? , ?)";
    private final static String DELETE_PASSENGER_REQUEST = "delete from passengers where id=?";
    private final static String READ_PASSENGER_REQUEST = "select * from passengers where id=?";
    private final static String UPDATE_PASSENGER_REQUEST = "";

    @Override
    public void create(Passenger passenger) {


    }

    @Override
    public Passenger read(Integer id) {
        return null;
    }

    @Override
    public void update(Passenger entity1, Passenger entity2) {

    }

    @Override
    public void delete(Integer id) {

    }
}
