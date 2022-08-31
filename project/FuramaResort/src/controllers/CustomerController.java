package controllers;

import services.impl.CustomerService;

import java.util.Scanner;

public class CustomerController {
    CustomerService customerService = new CustomerService();
    public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int functionTwoChoice;
            while (true) {
                System.out.println("-------Customer Management-------");
                System.out.println("1. Display list customers\n" +
                        "2. Add new customers\n" +
                        "3. Edit customers\n" +
                        "4. Return to main menu\n");
                System.out.print("Input your choice here: ");
                try {
                    functionTwoChoice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You have entered string type, please input a number!");
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
            }

            switch (functionTwoChoice) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }
    }
}
