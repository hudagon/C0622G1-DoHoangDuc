package controllers;

import java.util.Scanner;

public class EmployeeController {
    public void employeeMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------Employee Management-------");
            System.out.println("1. Display list employees\n" +
                    "2. Add new employee\n" +
                    "3. Edit employee\n" +
                    "4. Return to main menu\n");
            System.out.print("Input your choice here: ");
            int functionOneChoice = Integer.parseInt(scanner.nextLine());

            switch (functionOneChoice) {
                case 1:
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
