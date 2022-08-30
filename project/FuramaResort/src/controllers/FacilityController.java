package controllers;

import services.impl.FacilityService;

import java.util.Scanner;

public class FacilityController {
    FacilityService facilityService = new FacilityService();
    public void facilityMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------Facility Management-------");
            System.out.println("1. Display list Facility \n" +
                    "2. Add new Facility \n" +
                    "3. Display list facility maintenance \n" +
                    "4. Return to main menu\n");
            System.out.print("Input your choice here: ");
            int functionThreeChoice = Integer.parseInt(scanner.nextLine());

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
