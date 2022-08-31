package controllers;

import services.impl.BookingService;
import services.impl.ContractService;

import java.util.Scanner;

public class BookingController {
    BookingService bookingService = new BookingService();
    ContractService contractService = new ContractService();

    public void bookingMenu() {
        Scanner scanner = new Scanner(System.in);
        int functionFourChoice;
        while (true) {
            while (true) {
                try {
                    System.out.println("-------Booking Management-------");
                    System.out.println("1. Add new booking\n" +
                            "2. Display list booking\n" +
                            "3. Create new contracts\n" +
                            "4. Display list contracts\n" +
                            "5. Edit contracts\n" +
                            "6. Return to main menu\n");
                    System.out.print("Input your choice here: ");
                    functionFourChoice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You input String type not number try again!");
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
            }

            switch (functionFourChoice) {
                case 1:
                    bookingService.addNewBooking();
                    break;
                case 2:
                    bookingService.displayListBooking();
                    break;
                case 3:
                    contractService.add();
                    break;
                case 4:
                    contractService.display();
                    break;
                case 5:
                    contractService.editContract();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }
    }
}

