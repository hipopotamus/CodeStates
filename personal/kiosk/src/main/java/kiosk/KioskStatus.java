package kiosk;

import java.util.Arrays;

public class KioskStatus {
    private final KioskErrorHandler kioskErrorHandler = new KioskErrorHandler();

    private Menu menu;
    private int count;

    public int calculate() {
        return menu.price * count;
    }

    public boolean setMenu(int i) {
        if (!kioskErrorHandler.menuIndexError(i)) {
            return false;
        }
        this.menu = Arrays.stream(Menu.values())
                .filter(menu1 -> menu1.index == i)
                .findFirst()
                .get();
        return true;
    }

    public boolean setCount(int count) {
        if (!kioskErrorHandler.menuCountError(count)) {
            return false;
        }
        this.count = count;
        return true;
    }
}
