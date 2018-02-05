package sbitneva.action.actions;

import org.apache.log4j.Logger;
import sbitneva.action.Action;
import sbitneva.menu.Menu;

public class UnknownAction implements Action {

    private static Logger log = Logger.getLogger(UnknownAction.class.getName());

    @Override
    public void execute() {
        log.debug("execution started");
        System.out.println("WRONG COMMAND!");
        System.out.println(Menu.actions);
    }
}
