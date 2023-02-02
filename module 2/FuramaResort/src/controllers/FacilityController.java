package controllers;

import services.impl.FacilityService;

import java.util.Scanner;

public class FacilityController {
    FacilityService facilityService = new FacilityService();

    public void facilityMenu() {
        Scanner scanner = new Scanner(System.in);
        int functionThreeChoice;
        while (true) {
            while (true) {
                try {
                    System.out.println("-------Facility Management-------");
                    System.out.println("1. Display list Facility \n" +
                            "2. Add new Facility \n" +
                            "3. Display list facility maintenance \n" +
                            "4. Return to main menu\n");
                    System.out.print("Input your choice here: ");
                    functionThreeChoice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You input String type not number try again!");
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
            }

            switch (functionThreeChoice) {
                case 1:
                    facilityService.display();
                    break;
                case 2:
                    facilityService.add();
                    break;
                case 3:
                    facilityService.displayMaintenanceList();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }
    }
}
