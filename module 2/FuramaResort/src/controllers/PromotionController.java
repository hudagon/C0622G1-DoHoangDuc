package controllers;

import services.impl.PromotionService;

import java.util.Scanner;

public class PromotionController {
    PromotionService promotionService = new PromotionService();
    Scanner scanner = new Scanner(System.in);
    public void promotionMenu() {
        int functionFiveChoice;
        while (true) {
            System.out.println("-------Promotion Management-------");
            System.out.println("1. Display list customers use service\n" +
                    "2. Display list customers get voucher\n" +
                    "3. Return main menu\n");
            System.out.print("Input your choice here: ");
            while (true) {
                try {
                    functionFiveChoice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You input String type not number try again!");
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
            }

            switch (functionFiveChoice) {
                case 1:
                    promotionService.displayCustomersUseService();
                    break;
                case 2:
                    promotionService.displayCustomersGetVoucher();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }
    }
}
