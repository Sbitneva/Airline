package sbitneva.dao.sqlite;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import sbitneva.dao.CRUD;
import sbitneva.entity.Entity;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.aircrafts.AircraftBuilder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AircraftsDao implements CRUD {

    private static Logger log = Logger.getLogger(AircraftsDao.class.getName());

    @Autowired
    private DataSource dataSource;

    private static final String READ_REQUEST = "select * from aircrafts inner join aircraft_types on " +
            "(aircrafts.type_id = ? and aircrafts.type_id = aircraft_types.id);";
    @Override
    public void create(Entity entity) {

    }

    @Override
    public Aircraft read(Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_REQUEST)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                return new AircraftBuilder()
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name")).setCapacity(resultSet.getInt("carriage_capacity"))
                        .setFuelConsumption(resultSet.getInt("fuel_consumption"))
                        .setFlightRange(resultSet.getInt("flight_range"))
                        .setType(resultSet.getString("type_name"))
                        .buildAircraft();
            }

        } catch (SQLException e) {
            log.error(e.getClass() + " : " + e.getMessage());
        }

        return null;
    }

    @Override
    public void update(Entity entity1, Entity entity2) {

    }

    @Override
    public void delete(Integer id) {

    }
}
