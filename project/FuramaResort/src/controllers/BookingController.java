package controllers;

import services.impl.BookingService;

import java.text.ParseException;
import java.util.Scanner;

public class BookingController {
    BookingService bookingService = new BookingService();
    public void bookingMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------Booking Management-------");
            System.out.println("1. Add new booking\n" +
                    "2. Display list booking\n" +
                    "3. Create new contracts\n" +
                    "4. Display list contracts\n" +
                    "5. Edit contracts\n" +
                    "6. Return to main menu\n");
            System.out.print("Input your choice here: ");
            int functionFourChoice = Integer.parseInt(scanner.nextLine());

            switch (functionFourChoice) {
                case 1:
                    bookingService.addNewBooking();
                    break;
                case 2:
                    bookingService.displayListBooking();
                    break;
                case 3:
                    bookingService.createNewContract();
                    break;
                case 4:
                    bookingService.displayListContract();
                    break;
                case 5:
                    bookingService.editContract();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }
    }

}
