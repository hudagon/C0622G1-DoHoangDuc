package controllers;

import services.impl.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();

    public void employeeMenu() {
        Scanner scanner = new Scanner(System.in);
        int functionOneChoice;
        while (true) {
            while (true) {
                try {
                    System.out.println("-------Employee Management-------");
                    System.out.println("1. Display list employees\n" +
                            "2. Add new employee\n" +
                            "3. Edit employee\n" +
                            "4. Delete employee\n" +
                            "5. Return to main menu\n");
                    System.out.print("Input your choice here: ");
                    functionOneChoice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You input String type not number try again!");
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
            }

            switch (functionOneChoice) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    employeeService.delete();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }
    }
}
