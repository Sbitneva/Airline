package sbitneva.action.factory;

import sbitneva.action.Action;
import sbitneva.action.actions.*;

import java.util.HashMap;
import java.util.Map;

public class ActionsFactory {

    private static final String CALC_CAPACITIES_ACTION = "1";
    private static final String DISPLAY_SORTED_BY_FLIGHT_RANGE = "2";
    private static final String FIND_BY_FUEL_RANGE = "3";
    private static final String QUIT = "q";
    private static final String UNKNOWN = "unknown";

    private static final ActionsFactory actionsFactory = new ActionsFactory();

    private Map<String, Action> actionsMap = new HashMap();

    private ActionsFactory() {
        actionsMap.put(CALC_CAPACITIES_ACTION, new CalcCapacitiesAction());
        actionsMap.put(DISPLAY_SORTED_BY_FLIGHT_RANGE, new SortByFlightRangeAction());
        actionsMap.put(FIND_BY_FUEL_RANGE, new FindByFuelRangeAction());
        actionsMap.put(QUIT, new QuitAction());
        actionsMap.put(UNKNOWN, new UnknownAction());
    }

    public static ActionsFactory getActionsFactory() {
        return actionsFactory;
    }

    public Action getAction(final String action) {
        Action selectedAction = actionsMap.get(action);
        if (selectedAction == null) {
            selectedAction = actionsMap.get(UNKNOWN);
        }
        return selectedAction;
    }
}
