package sbitneva.action.actions;

import org.apache.log4j.Logger;
import sbitneva.action.Action;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.airline.Airline;
import sbitneva.menu.Menu;
import sbitneva.service.CalcCapacitiesService;

import java.util.ArrayList;

public class CalcCapacitiesAction implements Action {

    private static Logger log = Logger.getLogger(CalcCapacitiesAction.class.getName());

    @Override
    public void execute() {
        log.debug("execution started");
        CalcCapacitiesService service = CalcCapacitiesService.getService();
        service.calc();
        System.out.println("\n" + Menu.actions);

    }
}
