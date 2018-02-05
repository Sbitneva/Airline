package sbitneva;

import sbitneva.dao.AirlineDao;
import sbitneva.dao.AirlineDaoFactory;
import sbitneva.menu.Menu;

import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String... args) {
        System.out.println(Menu.actions);

        AirlineDao airlineDao = AirlineDaoFactory.getAirlineXmlDao();
        airlineDao.loadAircrafts();
        while (true) {
            String action = in.next();
            Menu.processAction(action);
        }
    }
}
