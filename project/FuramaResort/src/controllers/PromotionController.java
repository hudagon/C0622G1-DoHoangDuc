package controllers;

import java.util.Scanner;

public class PromotionController {
    Scanner scanner = new Scanner(System.in);
    public void promotionMenu() {
        while (true) {
            System.out.println("-------Promotion Management-------");
            System.out.println("1. Display list customers use service\n" +
                    "2. Display list customers get voucher\n" +
                    "3. Return main menu\n");
            System.out.print("Input your choice here: ");
            int functionFiveChoice = Integer.parseInt(scanner.nextLine());

            switch (functionFiveChoice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }
    }
}
