import kiosk.KioskService;
import kiosk.KioskStatus;

import java.util.Scanner;

public class Main {
    static KioskService kioskService = new KioskService();
    static KioskStatus kioskStatus = new KioskStatus();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        kioskService.printFirstGuide();

        while (true) {
            kioskService.printSelectMenu();

            int menuIndex = input.nextInt();
            System.out.println("");
            if (!kioskStatus.setMenu(menuIndex)) {
                continue;
            }
            break;
        }

        while (true) {
            kioskService.printCountMenu();

            int menuCount = input.nextInt();
            System.out.println("");
            if (!kioskStatus.setCount(menuCount)) {
                continue;
            }
            break;
        }

        kioskService.calculate(kioskStatus);
    }
}
