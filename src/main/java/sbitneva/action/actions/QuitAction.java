package sbitneva.action.actions;

import org.apache.log4j.Logger;
import sbitneva.action.Action;

public class QuitAction implements Action {

    private static Logger log = Logger.getLogger(QuitAction.class.getName());

    @Override
    public void execute() {
        log.debug("execution started");
        System.exit(0);
    }
}
