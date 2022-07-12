import delivery.DeliveryController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DeliveryController deliveryController = new DeliveryController();
        Scanner input = new Scanner(System.in);
        while (true) {
            deliveryController.printMainGuide();

            int index = input.nextInt();

            if (index == 6) {
                deliveryController.printEnd();
                break;
            }

            deliveryController.adaptor(index);
        }
    }
}
