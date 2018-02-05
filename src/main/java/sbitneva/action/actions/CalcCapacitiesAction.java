package sbitneva.action.actions;

import org.apache.log4j.Logger;
import sbitneva.action.Action;
import sbitneva.entity.airline.Airline;
import sbitneva.service.CalcCapacitiesService;

public class CalcCapacitiesAction implements Action {

    private static Logger log = Logger.getLogger(CalcCapacitiesAction.class.getName());

    @Override
    public void execute() {
        log.debug("execution started");
        Airline airline = Airline.getAirline();

        CalcCapacitiesService service = CalcCapacitiesService.getService();
        service.calc();
        System.out.println("total airline capacity = " + airline.getTotalCapacity());
        System.out.println("total carriage airline capacity = " + airline.getCarriageCapacity());
    }
}
