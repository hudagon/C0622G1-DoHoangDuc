package ss2_loop_in_java.exercise.display_type_of_drawing;

import java.util.Scanner;

public class DisplayDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, sum;

        System.out.println("Which one do you want to print (insert the number): ");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");

        System.out.print("Input here: ");
        choice = Integer.parseInt(scanner.nextLine());

        while (choice != 4) {
            switch (choice) {
                case 1:
                    System.out.println("*********");
                    System.out.println("*********");
                    System.out.println("*********");
                    break;
                case 2:
                    System.out.println("Which kind of square triangle do you want?");
                    System.out.println("1. Bottom left");
                    System.out.println("2. Top Left");
                    System.out.println("3. Bottom right");
                    System.out.println("4. Top right");
                    System.out.println("5. Nah, I changed my mind");
                    System.out.print("Input here: ");
                    choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            for (int i = 1; i <= 4; i++) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("*");
                                }
                                System.out.println();
                            }
                            break;
                        case 2:
                            for (int i = 4; i >= 1; i--) {
                                for (int j = 0; j < i; j++) {
                                    System.out.print("*");
                                }
                                System.out.println();
                            }
                            break;
                        case 3:
                            for (int i = 1; i <=4 ; i++) {
                                for (int j = 1; j <= (i * -1) + 4; j++) {
                                    System.out.print(" ");
                                }
                                for (int j = 1; j <= (i); j++) {
                                    System.out.print("*");
                                }
                                System.out.println();
                            }
                            break;
                        case 4:
                            for (int i = 1; i <= 4; i++) {
                                for (int j = 1; j <= (i - 1); j++) {
                                    System.out.print(" ");
                                }
                                for (int j = 1; j <= (i * -1) + 5; j++) {
                                    System.out.print("*");
                                }
                                System.out.println();
                            }
                            break;
                        case 5:
                            System.out.println("Which one do you want to print (insert the number): ");
                            System.out.println("1. Print the rectangle");
                            System.out.println("2. Print the square triangle");
                            System.out.println("3. Print isosceles triangle");
                            System.out.println("4. Exit");
                            break;
                    }
                    break;
                case 3:
                    sum = 1;
                    for (int i = 1; i <= 4; i++) {
                        for (int j = 4; j > i; j--) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < sum; j++) {
                            System.out.print("*");
                        }
                        sum = sum + 2;
                        System.out.println();
                    }
                    break;
            }
            System.out.println("Which one do you want to print? (insert the number): ");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.print("Input here: ");
            choice = Integer.parseInt(scanner.nextLine());
        }
    }
}
