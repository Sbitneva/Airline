package sbitneva;

import sbitneva.dao.AirlineDao;
import sbitneva.dao.AirlineDaoFactory;
import sbitneva.menu.Menu;

import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    private static void initAirline() {
        AirlineDao airlineDao = AirlineDaoFactory.getAirlineXmlDao();
        airlineDao.loadAircrafts();
    }

    public static void main(String... args) {
        Menu menu = Menu.getMenu();
        menu.init();
        initAirline();

        while (true) {
            String action = in.next();
            Menu.processAction(action);
        }
    }
}
