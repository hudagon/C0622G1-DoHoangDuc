package controllers;

import java.util.Scanner;

public class CustomerController {
    public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------Customer Management-------");
            System.out.println("1. Display list customers\n" +
                    "2. Add new customers\n" +
                    "3. Edit customers\n" +
                    "4. Return to main menu\n");
            System.out.print("Input your choice here: ");
            int functionTwoChoice = Integer.parseInt(scanner.nextLine());

            switch (functionTwoChoice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }
    }
}
