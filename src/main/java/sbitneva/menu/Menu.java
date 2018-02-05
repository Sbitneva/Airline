package sbitneva.menu;

import org.apache.log4j.Logger;
import sbitneva.action.Action;
import sbitneva.action.factory.ActionsFactory;

public class Menu {

    public final static String actions =
            "Choose action selecting the number from 1 to 3 and 'q' for the quit: \n" +
                    "1 - Calculate the total capacity and carrying capacity of all the aircraft in the airline.\n" +
                    "2 - Display the list of aircraft of the company sorted by flight range.\n" +
                    "3 - Find airplanes corresponding to a given range of fuel consumption parameters.\n" +
                    "q - quit";
    private static Logger log = Logger.getLogger(Menu.class.getName());
    private static Menu menu = new Menu();

    private Menu() {

    }

    public static Menu getMenu() {
        return menu;
    }

    public static void processAction(String action) {
        ActionsFactory actionsFactory = ActionsFactory.getActionsFactory();
        Action selectedAction = actionsFactory.getAction(action);
        log.debug(selectedAction.getClass().getSimpleName());
        selectedAction.execute();
        System.out.println("\n" + actions);
    }

    public void init() {
        System.out.println(actions);
    }
}
