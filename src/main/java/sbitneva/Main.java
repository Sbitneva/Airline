package sbitneva;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import sbitneva.config.ApplicationConfiguration;
import sbitneva.dao.sqlite.PassengersDao;
import sbitneva.entity.aircrafts.internal.Passenger;

public class Main {

    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String... args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);



    }
}
