package sbitneva;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import sbitneva.config.ApplicationConfiguration;
import sbitneva.service.CRUDAircraft;

public class Main {

    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String... args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        CRUDAircraft crudAircraft = (CRUDAircraft) context.getBean("crudAircraft");

        System.out.println(crudAircraft.readAircraft(1));

    }
}
