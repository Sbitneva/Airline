package sbitneva.action.actions;

import org.apache.log4j.Logger;
import sbitneva.action.Action;
import sbitneva.service.SortByFlightRangeService;


public class SortByFlightRangeAction implements Action {

    private static Logger log = Logger.getLogger(SortByFlightRangeAction.class.getName());


    /**
     * Display the aircraft list of the company sorted by flight range.
     */

    @Override
    public void execute() {
        log.debug("execution started");
        SortByFlightRangeService service = SortByFlightRangeService.getService();
        service.sort();
    }
}
