package controllers;

import java.util.Scanner;

public class FuramaController {
    public void displayMainMenu() {
        EmployeeController employeeController = new EmployeeController();
        CustomerController customerController = new CustomerController();
        FacilityController facilityController = new FacilityController();
        BookingController bookingController = new BookingController();
        PromotionController promotionController = new PromotionController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----------Welcome----------");
            System.out.println("1. Employee Management\n" +
                    "2. Customer Management\n" +
                    "3. Facility Management \n" +
                    "4. Booking Management\n" +
                    "5. Promotion Management\n" +
                    "6. Exit\n");
            System.out.print("Input your choice here: ");
            int mainChoice = Integer.parseInt(scanner.nextLine());
            boolean temp = true;

            switch (mainChoice) {
                case 1:
                    employeeController.employeeMenu();
                    break;
                case 2:
                    customerController.customerMenu();
                    break;
                case 3:
                    facilityController.facilityMenu();
                    break;
                case 4:
                    bookingController.bookingMenu();
                    break;
                case 5:
                    promotionController.promotionMenu();
                    break;
                case 6:
                    System.out.println("----------See you again!----------");
                    return;
            }
        }
    }
}
