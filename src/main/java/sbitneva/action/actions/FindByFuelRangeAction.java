package sbitneva.action.actions;

import org.apache.log4j.Logger;
import sbitneva.action.Action;
import sbitneva.entity.airline.Airline;
import sbitneva.service.FindByFuelRangeService;

import java.util.InputMismatchException;

import static sbitneva.Main.in;


public class FindByFuelRangeAction implements Action {

    private static final String ERROR_MESSAGE = "Range values must be positive numbers. \n Try again, please...";
    private static Logger log = Logger.getLogger(FindByFuelRangeAction.class.getName());

    @Override
    public void execute() {
        log.debug("execution started");

        int minRange = -1;
        int maxRange = -1;

        System.out.println("Enter min fuel consumption range");

        while (minRange == -1) {
            if(in.hasNext()) {
                try {
                    minRange = Integer.parseInt(in.next());
                    if (minRange < 0) {
                        System.out.println(ERROR_MESSAGE);
                        minRange = -1;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(ERROR_MESSAGE);
                }
            }
        }

        System.out.println("Enter max fuel consumption range");

        while (maxRange == -1) {

            if(in.hasNext()) {
                try {
                    maxRange = Integer.parseInt(in.next());
                    if (maxRange < 0) {
                        System.out.println(ERROR_MESSAGE);
                        maxRange = -1;
                    }
                    if (maxRange < minRange) {
                        System.out.println("Max range must be greater then min range = " + minRange + ".\n Try again, please");
                        maxRange = -1;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(ERROR_MESSAGE);
                }
            }
        }

        FindByFuelRangeService service = FindByFuelRangeService.getService();
        service.find(minRange, maxRange);

    }
}
