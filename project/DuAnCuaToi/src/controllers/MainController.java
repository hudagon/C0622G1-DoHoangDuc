package controllers;

import services.impl.PersonService;

import java.text.ParseException;
import java.util.Scanner;

public class MainController {
    private final PersonService personService = new PersonService();
    private final Scanner scanner = new Scanner(System.in);
    public void MainMenu() throws ParseException {
        while (true) {
            System.out.print("----------Welcome----------\n" +
                    "Choose the function according to the numbers to continue: \n" +
                    "1. Add new person\n" +
                    "2. Delete person\n" +
                    "3. Display person list\n" +
                    "4. Exit\n" +
                    "Input here: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    personService.add();
                    break;
                case 2:
                    personService.delete();
                    break;
                case 3:
                    personService.display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}
