import org.junit.Test;
import sbitneva.Main;
import sbitneva.menu.Menu;

public class MenuTest {

    @Test
    public void menuTest()
    {
        Menu.processAction("kshfijdfjvifjv");
        Menu.processAction("1");
        Menu.processAction("2");
    }
}
